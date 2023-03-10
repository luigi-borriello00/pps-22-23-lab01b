package e1;

import e1.factory.PieceFactoryImpl;
import e1.piece.Piece;
import e1.piece.PieceImpl;
import e1.piece.PiecePosition;
import e1.strategy.PieceStrategy;

import java.util.*;

public class LogicsImpl implements Logics {

	private final Piece targetPiece;
	private final Piece attackingPiece;
	private final Random random = new Random();
	private final int chessboardSize;
	 
    public LogicsImpl(int size){
    	this.chessboardSize = size;
        this.targetPiece = new PieceImpl(new PieceFactoryImpl().getPawnStrategy(), PiecePosition.getRandomPosition(size));
        this.attackingPiece = new PieceImpl(new PieceFactoryImpl().getKnightStrategy(), PiecePosition.getRandomPosition(size));
    }

	public LogicsImpl(int size, PiecePosition attackerPiecePosition, PiecePosition targetPiecePosition, PieceStrategy strategy) {
		this.chessboardSize = size;
		this.targetPiece = new PieceImpl(new PieceFactoryImpl().getPawnStrategy(), targetPiecePosition);
				new PiecePosition(targetPiecePosition.getX(), targetPiecePosition.getY());
		this.attackingPiece = new PieceImpl(new PieceFactoryImpl().getKnightStrategy(), attackerPiecePosition);
	}
    
	@Override
	public boolean hit(int row, int col) {
		PiecePosition newPosition = new PiecePosition(row, col);
		if(this.attackingPiece.getStrategy().canBeMoved(newPosition, this.attackingPiece.getPosition(),this.chessboardSize)){
			this.attackingPiece.setNewPosition(newPosition);
			return this.targetPiece.getPosition().equals(this.attackingPiece.getPosition());
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.attackingPiece.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.targetPiece.getPosition().equals(new Pair<>(row,col));
	}
}
