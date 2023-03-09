package e2.playground;

import e2.Pair;

public interface Cell {

    boolean isClicked();
    boolean isBomb();
    boolean hasFlag();
    void setBomb();
    void togglieFlag();
    void click();
    Pair<Integer, Integer> getCoordinates();
}
