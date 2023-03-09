package e2.playground;

import e2.Pair;

public interface Cell {

    boolean isClicked();
    boolean isBomb();
    boolean hasFlag();
    void setBomb();
    void toggleFlag();
    void click();
    int getCounterOfAdjacentBombs();
    void setCounterOfAdjacentBombs(int counter);

    Pair<Integer, Integer> getCoordinates();

}
