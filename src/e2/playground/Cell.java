package e2.playground;

import e2.Pair;

public interface Cell {

    boolean isClicked();
    boolean isAMine();
    boolean hasFlag();
    void setMine();
    void toggleFlag();
    void click();
    int getAdjacentMinesCounter();
    void setAdjacentMinesCounter(int counter);

    Pair<Integer, Integer> getCoordinates();

}
