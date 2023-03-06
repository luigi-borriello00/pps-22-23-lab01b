package e1;

import e1.factory.PieceFactory;
import e1.factory.PieceFactoryImpl;
import e1.strategy.PieceStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicStrategyTest {

    private final int SIZE = 5;
    private final Pair<Integer, Integer> piecePosition = new Pair<>(0, 4);
    PieceStrategy strategy;
    PieceFactory factory;

    @BeforeEach
    void setUp() {
        this.factory = new PieceFactoryImpl();
        this.strategy = factory.getKnightStrategy();
    }

    @Test
    void testCanBeMoved() {
        assertTrue(this.strategy.canBeMoved(3, 2, 4, 0, SIZE));
        assertFalse(this.strategy.canBeMoved(1, 1, 4, 0, SIZE));
        assertFalse(this.strategy.canBeMoved(2, 3, 4, 0, SIZE));


    }

    @Test
    void testCantBeMovedOutsideBoard() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.strategy.canBeMoved(-1, 0, 4, 0, SIZE));
        assertThrows(IndexOutOfBoundsException.class, () -> this.strategy.canBeMoved(0, -1, 4, 0, SIZE));
        assertThrows(IndexOutOfBoundsException.class, () -> this.strategy.canBeMoved(SIZE, 0, 4, 0, SIZE));
        assertThrows(IndexOutOfBoundsException.class, () -> this.strategy.canBeMoved(0, SIZE, 4, 0, SIZE));
    }

}