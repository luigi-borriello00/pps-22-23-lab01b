package e2.playground;

import e2.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private Cell cell;

    @BeforeEach
    void setUp() {
        this.cell = new CellImpl(new Pair<>(0, 0));
    }

    @Test
    void testIsInitiallyNotClicked() {
        assertFalse(this.cell.isClicked());
    }

    @Test
    void testIsInitiallyNotBomb() {
        assertFalse(this.cell.isBomb());
    }

    @Test
    void testIsInitiallyNotFlagged() {
        assertFalse(this.cell.hasFlag());
    }

    @Test
    void testIsClicked() {
        this.cell.click();
        assertTrue(this.cell.isClicked());
    }

    @Test
    void testIsBomb() {
        this.cell.setBomb();
        assertTrue(this.cell.isBomb());
    }

    @Test
    void testHasFlag() {
        this.cell.toggleFlag();
        assertTrue(this.cell.hasFlag());
    }

    @Test
    void testToggleFlag() {
        this.cell.toggleFlag();
        assertTrue(this.cell.hasFlag());
        this.cell.toggleFlag();
        assertFalse(this.cell.hasFlag());
    }

    @Test
    void testClick() {
        this.cell.click();
        assertTrue(this.cell.isClicked());
    }

    @Test
    void testInitiallyCounterOfAdjacentBombsIsZero() {
        assertEquals(0, this.cell.getCounterOfAdjacentBombs());
    }

    @Test
    void testGetCounterOfAdjacentBombs() {
        this.cell.setCounterOfAdjacentBombs(3);
        assertEquals(3, this.cell.getCounterOfAdjacentBombs());
    }

    @Test
    void testGetCoordinates() {
        assertEquals(new Pair<>(0, 0), this.cell.getCoordinates());
    }
}