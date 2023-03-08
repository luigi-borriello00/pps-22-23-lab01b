package e2;

import e2.playground.*;

import java.util.stream.Stream;

public class LogicsImpl implements Logics {
    private final Grid grid;


    public LogicsImpl(int size, int numberOfBombs) {
        this.grid = new GridImpl(size, numberOfBombs);
    }

    @Override
    public Grid getGrid() {
        return this.grid;
    }

    @Override
    public boolean isThereVictory() {
        return this.grid.getCells().stream()
                .filter(cell -> !cell.isBomb())
                .allMatch(Cell::isClicked);
    }

    @Override
    public boolean isGameOver() {
        return this.grid.getCells().stream()
                .filter(Cell::isBomb)
                .anyMatch(Cell::isClicked);
    }

}
