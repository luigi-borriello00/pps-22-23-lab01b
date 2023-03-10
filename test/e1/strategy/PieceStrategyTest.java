package e1.strategy;

import e1.Pair;
import e1.factory.PieceFactory;
import e1.factory.PieceFactoryImpl;
import e1.piece.PiecePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceStrategyTest {

    private final int SIZE = 5;
    private final Pair<Integer, Integer> piecePosition = new Pair<>(0, 4);
    private PieceStrategy strategy;
    private PieceFactory factory;

    @BeforeEach
    void setUp() {
        this.factory = new PieceFactoryImpl();
        this.strategy = factory.getKnightStrategy();
    }

    @Test
    void testCanBeMoved() {
        assertTrue(this.strategy.canBeMoved(new PiecePosition(3, 2), new PiecePosition(4, 0), SIZE));
        assertFalse(this.strategy.canBeMoved(new PiecePosition(1, 1), new PiecePosition( 4, 0), SIZE));
        assertFalse(this.strategy.canBeMoved(new PiecePosition(2, 3), new PiecePosition( 4, 0), SIZE));
    }

    @Test
    void testCantBeMovedOutsideBoard() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.strategy.canBeMoved(new PiecePosition(-1, 0), new PiecePosition(4, 0), SIZE));
        assertThrows(IndexOutOfBoundsException.class, () -> this.strategy.canBeMoved( new PiecePosition(0, -1), new PiecePosition(4, 0), SIZE));
        assertThrows(IndexOutOfBoundsException.class, () -> this.strategy.canBeMoved(new PiecePosition(SIZE, 0), new PiecePosition(4, 0), SIZE));
        assertThrows(IndexOutOfBoundsException.class, () -> this.strategy.canBeMoved(new PiecePosition(0, SIZE), new PiecePosition( 4, 0), SIZE));
    }

}