package e2.playground;

import e2.Pair;

public class CellImpl implements Cell {

    private final Pair<Integer, Integer> coordinates;
    private boolean isClicked;
    private boolean isBomb;
    private boolean hasFlag;

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
    public boolean isBomb() {
        return this.isBomb;
    }

    @Override
    public boolean hasFlag() {
        return this.hasFlag;
    }

    @Override
    public void setBomb() {
        this.isBomb = true;
    }

    @Override
    public void togglieFlag() {
        this.hasFlag = !this.hasFlag;
    }

    @Override
    public void click() {
        isClicked = true;
    }

    @Override
    public Pair<Integer, Integer> getCoordinates() {
        return coordinates;
    }
}
