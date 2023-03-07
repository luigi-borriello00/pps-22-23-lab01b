package e1;

import e1.factory.PieceFactoryImpl;
import e1.position.PiecePosition;
import e1.strategy.PieceStrategy;

import java.util.*;

public class LogicsImpl implements Logics {

	private final PiecePosition targetPiece;
	private PiecePosition attackingPiece;
	private final PieceStrategy attackerPieceStrategy;
	private final Random random = new Random();
	private final int chessboardSize;
	 
    public LogicsImpl(int size){
		this.attackerPieceStrategy = new PieceFactoryImpl().getKnightStrategy();
    	this.chessboardSize = size;
        this.targetPiece = PiecePosition.getRandomPosition(size);
        this.attackingPiece = PiecePosition.getRandomPosition(size);
    }

	public LogicsImpl(int size, PiecePosition attackerPiecePosition, PiecePosition targetPiecePosition, PieceStrategy strategy) {
		this.chessboardSize = size;
		this.attackerPieceStrategy = strategy;
		this.targetPiece = new PiecePosition(targetPiecePosition.getX(), targetPiecePosition.getY());
		this.attackingPiece = new PiecePosition(attackerPiecePosition.getX(), attackerPiecePosition.getY());
	}
    
	@Override
	public boolean hit(int row, int col) {
		if(this.attackerPieceStrategy.canBeMoved(new PiecePosition(row, col), this.attackingPiece,this.chessboardSize)){
			this.attackingPiece = new PiecePosition(row,col);
			return this.targetPiece.equals(this.attackingPiece);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.attackingPiece.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.targetPiece.equals(new Pair<>(row,col));
	}
}
