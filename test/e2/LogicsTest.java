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

    }

    @Test
    void testIfClickingOnBombEndsTheGame(){
        this.logics.clickCell(this.logics.getBombsCells().get(0));
        assertTrue(this.logics.isGameOver());
    }

    @Test
    void testIfVictoryIsAchieved(){
        this.logics.getAllCells().stream()
                .filter(cell -> ! this.logics.getBombsCells().contains(cell))
                .forEach(this.logics::clickCell);
        assertTrue(this.logics.isThereVictory());
    }
}