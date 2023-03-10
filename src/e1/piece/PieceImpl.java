package e1.piece;

import e1.strategy.PieceStrategy;

public class PieceImpl implements Piece{
    private PieceStrategy pieceStrategy;
    private PiecePosition piecePosition;
    public PieceImpl(PieceStrategy pieceStrategy, PiecePosition piecePosition) {
        this.pieceStrategy = pieceStrategy;
        this.piecePosition = piecePosition;
    }

    @Override
    public PieceStrategy getStrategy() {
        return this.pieceStrategy;
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
