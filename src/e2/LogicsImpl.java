package e2;

import e2.playground.Grid;
import e2.playground.GridImpl;

import java.util.stream.Stream;

public class LogicsImpl implements Logics {
    private Grid grid;


    public LogicsImpl(int size, int numberOfBombs) {
        this.grid = new GridImpl(size, numberOfBombs);
    }

    @Override
    public Grid getGrid() {
        return this.grid;
    }
}
