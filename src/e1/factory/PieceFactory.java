package e1.factory;

import e1.piece.Piece;
import e1.piece.PiecePosition;

public interface PieceFactory {

    public Piece getKnight(PiecePosition position);

    public Piece getPawn(PiecePosition position);
}
