package e1.piece;

import e1.strategy.MovementStrategy;

public class PieceImpl implements Piece{
    private final MovementStrategy movementStrategy;
    private PiecePosition piecePosition;
    public PieceImpl(MovementStrategy movementStrategy, PiecePosition piecePosition) {
        this.movementStrategy = movementStrategy;
        this.piecePosition = piecePosition;
    }

    @Override
    public MovementStrategy getStrategy() {
        return this.movementStrategy;
    }

    @Override
    public PiecePosition getPosition() {
        return this.piecePosition;
    }

    @Override
    public void setNewPosition(PiecePosition newPosition) {
        this.piecePosition = newPosition;
    }
}
