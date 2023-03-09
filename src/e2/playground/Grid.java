package e2.playground;

import e2.Pair;

import java.util.List;

public interface Grid {

    /**
     * Returns the size of the grid
     * @return
     */
    int getSize();

    /**
     * Returns the cell at the given coordinates
     * @param coordinates coordinates of the cell to be returned
     * @return
     */
    Cell getCellFromCoordinates(Pair<Integer, Integer> coordinates);

    /**
     * Returns a list of all cells
     * @return
     */
    List<Cell> getCells();

    /**
     * Returns a list of all mines
     * @return
     */
    List<Cell> getMines();

    /**
     * Returns a list of all clicked cells
     * @return
     */
    List<Cell> getClickedCells();

    /**
     * Returns a list of all adjacent cells to the given cell
     * @param targetCell cell to which the adjacent cells are returned
     * @return
     */
    List<Cell> getAdjacentCells(Cell targetCell);

}
