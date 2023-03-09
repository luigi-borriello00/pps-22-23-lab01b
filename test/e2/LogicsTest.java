package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class LogicsTest {


    private Logics logics;

    @BeforeEach
    void setUp() {
        int size = 5;
        int numberOfBombs = 3;
        this.logics = new LogicsImpl(size, numberOfBombs);
    }

    @Test
    void testIfNotClickingOnBombDoesNotEndTheGame(){
        Pair<Integer, Integer> firstCellNotBomb = this.logics.getAllCells().stream()
                .filter(cell -> ! this.logics.getBombsCells().contains(cell))
                .findFirst()
                .orElseThrow()
                ;
        this.logics.clickCell(firstCellNotBomb);
        assertFalse(this.logics.isGameOver());
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