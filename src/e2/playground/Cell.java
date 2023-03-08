package e2.playground;

import e2.Pair;

public interface Cell {

    boolean isClicked();
    boolean isBomb();
    void setBomb();
    void click();
    Pair<Integer, Integer> getCoordinates();
}
