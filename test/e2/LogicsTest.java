package e2;

import e2.playground.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogicsTest {


    private final int size = 5;
    private final int numberOfBombs = 3;
    private Logics logics;

    @BeforeEach
    void setUp() {
        this.logics = new LogicsImpl(this.size, this.numberOfBombs);
    }

    @Test
    void testIfNotClickingOnBombDoesNotEndTheGame(){
        final Cell cell = this.logics.getGrid().getCells().stream()
                .filter(c -> !c.isBomb())
                .findFirst().get();
        cell.click();
        assertFalse(this.logics.isThereVictory());
        assertFalse(cell.isBomb());
    }

    @Test
    void testIfClickingOnBombEndsTheGame(){
        this.logics.getGrid().getBombs().get(0).click();
        assertTrue(this.logics.isGameOver());
    }

    @Test
    void testIfVictoryIsAchieved(){
        this.logics.getGrid().getCells().stream()
                .filter(cell -> !cell.isBomb())
                .forEach(Cell::click);
        assertTrue(this.logics.isThereVictory());
    }
}