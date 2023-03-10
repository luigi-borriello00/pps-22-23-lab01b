package e1.piece;

import e1.strategy.MovementStrategy;

public interface Piece {

    MovementStrategy getStrategy();

    PiecePosition getPosition();

    void setNewPosition(PiecePosition newPosition);
}
