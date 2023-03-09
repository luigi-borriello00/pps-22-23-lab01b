package e2;

import e2.playground.*;

import java.util.List;
import java.util.stream.Stream;

public class LogicsImpl implements Logics {
    private final Grid grid;


    public LogicsImpl(int size, int numberOfBombs) {
        this.grid = new GridImpl(size, numberOfBombs);
    }

    @Override
    public List<Pair<Integer, Integer>> getAllCells() {
        return this.grid.getCells().stream()
                .map(Cell::getCoordinates)
                .toList();
    }

    @Override
    public List<Pair<Integer, Integer>> getClickedCells() {
        return this.grid.getCells().stream()
                .filter(Cell::isClicked)
                .map(Cell::getCoordinates)
                .toList();
    }

    @Override
    public List<Pair<Integer, Integer>> getFlaggedCells() {
        return this.grid.getCells().stream()
                .filter(Cell::hasFlag)
                .map(Cell::getCoordinates)
                .toList();
    }

    @Override
    public List<Pair<Integer, Integer>> getBombsCells() {
        return this.grid.getBombs().stream()
                .map(Cell::getCoordinates)
                .toList();
    }

    @Override
    public boolean clickCell(Pair<Integer, Integer> coordinates) {
        return this.grid.clickCell(grid.getCells().stream()
                .filter(cell -> cell.getCoordinates().equals(coordinates))
                .findFirst().get());
    }

    @Override
    public void toggleFlag(Pair<Integer, Integer> coordinates) {
        this.grid.getCells().stream()
                .filter(cell -> cell.getCoordinates().equals(coordinates))
                .findFirst().get().toggleFlag();
    }

    @Override
    public int getAdjacentBombs(Pair<Integer, Integer> coordinates) {
       Cell targetCell = this.grid.getCells().stream()
                .filter(cell -> cell.getCoordinates().equals(coordinates))
                .findFirst().get();
        return targetCell.getCounterOfAdjacentBombs();

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
