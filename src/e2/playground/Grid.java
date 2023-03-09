package e2.playground;

import e2.Pair;

import java.util.List;

public interface Grid {

    int getSize();
    List<Cell> getCells();
    List<Cell> getBombs();
    List<Cell> getClickedCells();
    List<Cell> getAdjacentCells(Cell targetCell);
    void checkCombo(Cell targetCell);


}
