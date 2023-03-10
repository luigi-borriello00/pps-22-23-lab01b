package e1.factory;

import e1.piece.Piece;
import e1.piece.PieceImpl;
import e1.piece.PiecePosition;
import e1.strategy.MovementStrategy;

public class PieceFactoryImpl implements PieceFactory {
    @Override
    public Piece getKnight(PiecePosition position) {
        return new PieceImpl(new MovementStrategy() {
            @Override
            public boolean canBeMoved(PiecePosition newPosition, PiecePosition actualPosition, int size) {
                if (!newPosition.isOnBoard(size)) {
                    throw new IndexOutOfBoundsException();
                }
                // Below a compact way to express allowed moves for the knight
                int newX = newPosition.getX() - actualPosition.getX();
                int newY = newPosition.getY() - actualPosition.getY();
                return newX != 0 && newY != 0 && Math.abs(newX) + Math.abs(newY) == 3;
            }
        }, position);
    }

    @Override
    public Piece getPawn(PiecePosition position) {
        return new PieceImpl(new MovementStrategy() {
            @Override
            public boolean canBeMoved(PiecePosition newPosition, PiecePosition actualPosition, int chessboardSize) {
                return false;
            }
        }, position);
    }

}
