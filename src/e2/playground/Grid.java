package e2.playground;

import e2.Pair;

import java.util.List;

public interface Grid {

    int getSize();
    Cell getCell(Pair<Integer, Integer> coordinates);
    List<Cell> getCells();
    void click(Cell cell);
    List<Cell> getClickedCells();

    List<Cell> getBombs();
    List<Cell> getAdjacentCells(Pair<Integer, Integer> coordinates);

}
