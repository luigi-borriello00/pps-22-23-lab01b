package e1;

import e1.position.Position;
import e1.position.PositionImpl;
import e1.strategy.PieceStrategy;

import java.util.*;

public class LogicsImpl implements Logics {

	private final Position pawnPosition;
	private final Position piecePosition;
	private final Random random = new Random();
	private final int size;
	private PieceStrategy pieceStrategy;
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawnPosition = new PositionImpl(this.randomEmptyPosition());
        this.piecePosition = new PositionImpl(this.randomEmptyPosition());
    }

	public LogicsImpl(int size, Pair<Integer, Integer> piecePosition, Pair<Integer, Integer> pawnPosition, PieceStrategy strategy) {
		this.size = size;
		this.pieceStrategy = strategy;
		this.pawnPosition = new PositionImpl(pawnPosition);
		this.piecePosition = new PositionImpl(piecePosition);
	}

    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawnPosition!=null && this.pawnPosition.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if(this.pieceStrategy.canBeMoved(row,col,this.piecePosition.getPosition().getX(),this.piecePosition.getPosition().getY(),8)){
			this.piecePosition.setPosition(new Pair<>(row,col));
			return this.pawnPosition.equals(this.piecePosition);
		}
		else {
			return false;
		}
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.piecePosition.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawnPosition.getPosition().equals(new Pair<>(row,col));
	}
}
