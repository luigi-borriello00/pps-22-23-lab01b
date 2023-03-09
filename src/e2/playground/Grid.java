package e2.playground;

import e2.Pair;

import java.util.List;

public interface Grid {

    int getSize();
    Cell getCellFromCoordinates(Pair<Integer, Integer> coordinates);
    List<Cell> getCells();
    List<Cell> getMines();
    List<Cell> getClickedCells();
    List<Cell> getAdjacentCells(Cell targetCell);

}
