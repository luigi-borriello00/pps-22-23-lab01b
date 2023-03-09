package e2.playground;

import e2.Pair;

public interface Cell {

    /**
     * Returns the coordinates of the cell
     * @return
     */
    Pair<Integer, Integer> getCoordinates();

    /**
     * Returns true if the cell has been clicked
     * @return
     */
    boolean isClicked();

    /**
     * Returns true if the cell is a mine
     * @return
     */
    boolean isAMine();

    /**
     * Returns true if the cell has a flag
     * @return
     */
    boolean hasFlag();

    /**
     * Returns the number of adjacent mines to the cell
     * @return
     */
    void setMine();

    /**
     * Toggles the flag on the cell
     */
    void toggleFlag();

    /**
     * Clicks on the cell
     */
    void click();

    /**
     * Returns the number of adjacent mines to the cell
     * @return
     */
    int getAdjacentMinesCounter();

    /**
     * Sets the number of adjacent mines to the cell
     * @param counter
     */
    void setAdjacentMinesCounter(int counter);



}
