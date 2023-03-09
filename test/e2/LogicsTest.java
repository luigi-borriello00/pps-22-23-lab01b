package e2;

import e2.playground.Cell;
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
                .filter(cell -> ! this.logics.getMines().contains(cell))
                .findFirst()
                .orElseThrow()
                ;
        this.logics.clickCell(firstCellNotBomb);
        assertFalse(this.logics.isGameOver());
    }

    @Test
    void testIfClickingOnBombEndsTheGame(){
        this.logics.clickCell(this.logics.getMines().get(0));
        assertTrue(this.logics.isGameOver());
    }

    @Test
    void testIfVictoryIsAchieved(){
        this.logics.getAllCells().stream()
                .filter(cell -> ! this.logics.getMines().contains(cell))
                .forEach(this.logics::clickCell);
        assertTrue(this.logics.isThereVictory());
    }

    @Test
    void testCombo(){
        assertEquals(0, this.logics.getClickedCells().size());
        Pair<Integer, Integer> cellNotInEdges = this.logics.getAllCells().stream()
                .filter(cell -> ! this.logics.getMines().contains(cell))
                .filter(cell -> cell.getX() > 0 && cell.getX() < Math.sqrt(this.logics.getAllCells().size()) - 1)
                .filter(cell -> cell.getY() > 0 && cell.getY() < Math.sqrt(this.logics.getAllCells().size()) - 1)
                .findFirst()
                .orElseThrow();
        this.logics.clickCell(cellNotInEdges);
        assertEquals(9, this.logics.getClickedCells().size());
    }
}