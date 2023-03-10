package e1.piece;

import e1.strategy.PieceStrategy;

public interface Piece {

    PieceStrategy getStrategy();

    PiecePosition getPosition();

    void setNewPosition(PiecePosition newPosition);
}
