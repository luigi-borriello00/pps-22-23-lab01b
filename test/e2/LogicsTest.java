package e2;

import e2.playground.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;
import java.util.stream.Stream;

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
    void checkNumberOfBombs(){
        assertEquals(numberOfBombs, this.logics.getGrid().getBombs().size());
        assertNotEquals(numberOfBombs+1, this.logics.getGrid().getBombs().size());
    }

    @Test
    void checkIfThereAreDuplicates(){
        assertEquals(this.numberOfBombs, this.logics.getGrid().getBombs().stream().distinct().count());
    }

    @Test
    void testWhenBombsAreMoreThenBoardSize(){
        assertThrows(IllegalArgumentException.class, () -> new LogicsImpl(this.size, this.size*this.size+1));
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

    @Test
    void testNumberOfAdjacentCells(){
        final int cellNotInEdges = 6;
        final Cell cell = this.logics.getGrid().getCells().get(cellNotInEdges);
        final List<Cell> adjacentCells = this.logics.getGrid().getAdjacentCells(cell);
        assertEquals(8, adjacentCells.size());
    }

    @Test
    void testNumberOfAdjacentCellsOnTheEdge(){
        final Cell cell = this.logics.getGrid().getCells().get(0);
        final List<Cell> adjacentCells = this.logics.getGrid().getAdjacentCells(cell);
        assertEquals(3, adjacentCells.size());
        final List<Cell> cellsInTheEdges = this.logics.getGrid().getCells().stream()
                .filter(c -> this.logics.getGrid().getAdjacentCells(c).size() == 3)
                .toList();
        assertEquals(4, cellsInTheEdges.size());
    }

    @Test
    void testIfCellsCanBeFlagged(){
        final List<Cell> cells = this.logics.getGrid().getCells().stream()
                .filter(c -> !c.isBomb())
                .toList();
        int numberOfFlags = 4;
        cells.stream()
                .limit(numberOfFlags)
                .forEach(Cell::togglieFlag);
        List<Cell> flaggedCells = this.logics.getGrid().getCells().stream()
                .filter(Cell::hasFlag)
                .toList();
        assertEquals(numberOfFlags, flaggedCells.size());

    }

    @Test
    void testCombo(){

        assertEquals(0, this.logics.getGrid().getClickedCells().size());
        final Cell cell = this.logics.getGrid().getCells().stream()
                .filter(c -> !c.isBomb())
                .filter(c -> this.logics.getGrid().getAdjacentCells(c).stream().count() == 8)
                .filter(c -> this.logics.getGrid().getAdjacentCells(c).stream().noneMatch(Cell::isBomb))
                .findFirst().get();
        cell.click();
        this.logics.getGrid().checkCombo(cell);
        assertEquals(9, this.logics.getGrid().getClickedCells().size());
    }

    @Test
    void testGridSize(){
        assertThrows(IllegalArgumentException.class, () -> new LogicsImpl(0, 10));

    }


}