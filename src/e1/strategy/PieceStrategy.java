package e1.strategy;

import e1.piece.PiecePosition;

public interface PieceStrategy {

    /**
     * @param newPosition
     * @param actualPosition
     * @param chessboardSize
     * @return true if the piece can be moved to the new position
     */
    boolean canBeMoved(PiecePosition newPosition, PiecePosition actualPosition, int chessboardSize);

}
