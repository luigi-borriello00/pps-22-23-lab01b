package e2.playground;

import e2.LogicsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    private final int numberOfBombs = 3;
    private final int size = 5;
    private Grid grid;

    @BeforeEach
    void setUp() {
        this.grid = new GridImpl(size, numberOfBombs);
    }

    @Test
    void testIfGridSizeIsCorrect(){
        assertEquals(this.size, this.grid.getSize());
    }

    @Test
    void testIfNumberOfBombsIsCorrect(){
        assertEquals(this.numberOfBombs, this.grid.getBombs().size());
    }

    @Test
    void checkIfThereAreDuplicates(){
        assertEquals(this.numberOfBombs, this.grid.getBombs().stream().distinct().count());
    }

    @Test
    void testWhenBombsAreMoreThenBoardSize(){
        assertThrows(IllegalArgumentException.class, () -> new LogicsImpl(this.size, this.size*this.size+1));
    }

    @Test
    void testWhenGridSizeIsLessThenOne(){
        assertThrows(IllegalArgumentException.class, () -> new LogicsImpl(0, 10));
    }

    @Test
    void testIfNumberOfCellsIsCorrect(){
        assertEquals(this.size*this.size, this.grid.getCells().size());
    }

    @Test
    void testIfNumberOfClickedCellsIsCorrect(){
        this.grid.getCells().get(0).click();
        assertEquals(1, this.grid.getClickedCells().size());
    }

    @Test
    void testNumberOfAdjacentCells(){
        assertEquals(3, this.grid.getAdjacentCells(this.grid.getCells().get(0)).size());
    }

    @Test
    void testNumberOfAdjacentCellsOnTheEdge(){
        final List<Cell> cellsInTheEdges = this.grid.getCells().stream()
                .filter(c -> this.grid.getAdjacentCells(c).size() == 3)
                .toList();
        assertEquals(4, cellsInTheEdges.size());
    }

    @Test
    void testCombo(){

        assertEquals(0, grid.getClickedCells().size());
        final Cell cell = grid.getCells().stream()
                .filter(c -> !c.isBomb())
                .filter(c -> this.grid.getAdjacentCells(c).stream().count() == 8)
                .filter(c -> this.grid.getAdjacentCells(c).stream().noneMatch(Cell::isBomb))
                .findFirst().get();
        this.grid.clickCell(cell);
        assertEquals(9, this.grid.getClickedCells().size());
    }

}