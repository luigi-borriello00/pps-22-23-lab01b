package e2.playground;

import e2.Pair;

public class CellImpl implements Cell {

    private final Pair<Integer, Integer> coordinates;
    private boolean isClicked;
    private boolean isBomb;
    private boolean hasFlag;
    private int counterOfAdjacentBombs;

    public CellImpl(Pair<Integer, Integer> coordinates) {
        this.coordinates = coordinates;
        this.isClicked = false;
        this.isBomb = false;
    }

    @Override
    public boolean isClicked() {
        return isClicked;
    }

    @Override
    public boolean isAMine() {
        return this.isBomb;
    }

    @Override
    public boolean hasFlag() {
        return this.hasFlag;
    }

    @Override
    public void setMine() {
        this.isBomb = true;
    }

    @Override
    public void toggleFlag() {
        this.hasFlag = !this.hasFlag;
    }

    @Override
    public void click() {
        isClicked = true;
    }

    @Override
    public int getAdjacentMinesCounter() {
        return this.counterOfAdjacentBombs;
    }

    @Override
    public Pair<Integer, Integer> getCoordinates() {
        return coordinates;
    }

    @Override
    public void setAdjacentMinesCounter(int counter) {
        this.counterOfAdjacentBombs = counter;
    }
}
