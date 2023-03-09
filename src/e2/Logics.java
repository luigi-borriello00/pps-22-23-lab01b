package e2;

import java.util.List;

public interface Logics {

    /**
     * Clicks on a cell
     * @param cellCoordinates coordinates of the cell to be clicked
     */
    void clickCell(Pair<Integer, Integer> cellCoordinates);

    /**
     * Toggles a flag on a cell
     * @param cellCoordinates coordinates of the cell to be flagged
     */
    void toggleFlag(Pair<Integer, Integer> cellCoordinates);

    /**
     * Returns true if the cell is a mine
     * @param cellCoordinates coordinates of the cell to be checked
     * @return true if the cell is a mine
     */
    boolean isAMine(Pair<Integer, Integer> cellCoordinates);

    /**
     * Return the number of adjacent mines to a cell
     * @param cellCoordinates
     * @return
     */
    int getAdjacentMinesCounter(Pair<Integer, Integer> cellCoordinates);

    /**
     * Returns true if the game is over
     * @return
     */
    boolean isThereVictory();

    /**
     * Returns true if the game is over
     * @return
     */
    boolean isGameOver();

    /**
     * Returns a list of all cells coordinates
     * @return
     */
    List<Pair<Integer, Integer>> getAllCells();

    /**
     * Returns a list of all clicked cells coordinates
     * @return
     */
    List<Pair<Integer, Integer>> getClickedCells();

    /**
     * Returns a list of all flagged cells coordinates
     * @return
     */
    List<Pair<Integer, Integer>> getFlaggedCells();
    /**
     * Returns a list of all mines coordinates
     * @return
     */
    List<Pair<Integer, Integer>> getMines();

}
