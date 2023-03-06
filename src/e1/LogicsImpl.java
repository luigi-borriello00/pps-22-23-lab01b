package e1;

import e1.strategy.PieceStrategy;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> piece;
	private final Random random = new Random();
	private final int size;
	private PieceStrategy pieceStrategy;
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.piece = this.randomEmptyPosition();
    }

	public LogicsImpl(int size, Pair<Integer, Integer> piecePosition, Pair<Integer, Integer> pawnPosition, PieceStrategy strategy) {
		this.size = size;
		this.piece = piecePosition;
		this.pawn = pawnPosition;
		this.pieceStrategy = strategy;
	}

    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if(this.pieceStrategy.canBeMoved(row,col,this.piece.getX(),this.piece.getY(),8)){
			this.piece = new Pair<>(row,col);
			return this.pawn.equals(this.piece);
		}
		else {
			return false;
		}
	}


	@Override
	public boolean hasKnight(int row, int col) {
		return this.piece.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}
}
