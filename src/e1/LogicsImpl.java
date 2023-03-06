package e1;

import e1.factory.PieceFactoryImpl;
import e1.position.PiecePosition;
import e1.strategy.PieceStrategy;

import java.util.*;

public class LogicsImpl implements Logics {

	private final PiecePosition pawnPosition;
	private PiecePosition piecePosition;
	private final Random random = new Random();
	private final int chessboardSize;
	private final PieceStrategy pieceStrategy;
	 
    public LogicsImpl(int size){
		this.pieceStrategy = new PieceFactoryImpl().getKnightStrategy();
    	this.chessboardSize = size;
        this.pawnPosition = PiecePosition.getRandomPosition(size);
        this.piecePosition = PiecePosition.getRandomPosition(size);
    }

	public LogicsImpl(int size, Pair<Integer, Integer> piecePosition, Pair<Integer, Integer> pawnPosition, PieceStrategy strategy) {
		this.chessboardSize = size;
		this.pieceStrategy = strategy;
		this.pawnPosition = new PiecePosition(pawnPosition.getX(), pawnPosition.getY());
		this.piecePosition = new PiecePosition(piecePosition.getX(), piecePosition.getY());
	}
    
	@Override
	public boolean hit(int row, int col) {
		if(this.pieceStrategy.canBeMoved(new PiecePosition(row, col), this.piecePosition,this.chessboardSize)){
			this.piecePosition = new PiecePosition(row,col);
			return this.pawnPosition.equals(this.piecePosition);
		}
		else {
			return false;
		}
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.piecePosition.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawnPosition.equals(new Pair<>(row,col));
	}
}
