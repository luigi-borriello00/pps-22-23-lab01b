package e1.piece;

import e1.factory.PieceFactory;
import e1.factory.PieceFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceImplTest {

    private Piece piece;
    private PieceFactory factory;

    @BeforeEach
    void setUp() {
        this.factory = new PieceFactoryImpl();
        this.piece = this.factory.getKnight(new PiecePosition(0, 0));
    }

    @Test
    void testGetPosition() {
        assertEquals(new PiecePosition(0, 0), this.piece.getPosition());
    }

    @Test
    void testSetNewPosition() {
        this.piece.setNewPosition(new PiecePosition(1, 1));
        assertEquals(new PiecePosition(1, 1), this.piece.getPosition());
    }

}