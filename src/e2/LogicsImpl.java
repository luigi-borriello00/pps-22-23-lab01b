package e2;

import e2.playground.*;

import java.util.List;

public class LogicsImpl implements Logics {
    private final Grid grid;

    public LogicsImpl(int size, int numberOfMines) {
        this.grid = new GridImpl(size, numberOfMines);
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
    public List<Pair<Integer, Integer>> getMines() {
        return this.grid.getMines().stream()
                .map(Cell::getCoordinates)
                .toList();
    }
    private void setAdjacentMinesCounter(Cell targetCell) {
        List<Cell> adjacentMines = this.grid.getAdjacentCells(targetCell).stream()
                .filter(Cell::isAMine)
                .toList();
        targetCell.setAdjacentMinesCounter(adjacentMines.size());
    }

    @Override
    public void clickCell(Pair<Integer, Integer> cellCoordinates) {
        Cell targetCell = this.grid.getCellFromCoordinates(cellCoordinates);
        targetCell.click();
        if(!targetCell.isAMine()){
            this.setAdjacentMinesCounter(targetCell);
            this.checkCombo(targetCell);
        }
    }

    private void checkCombo(Cell targetCell) {
        List<Cell> adjacentCells = this.grid.getAdjacentCells(targetCell);
        if(!targetCell.isAMine()){
            List<Cell> adjacentMines = adjacentCells.stream()
                    .filter(Cell::isAMine)
                    .toList();
            if (adjacentMines.size() == 0){
                adjacentCells.forEach(Cell::click);
                adjacentCells.forEach(this::setAdjacentMinesCounter);
            }
        }

    }

    @Override
    public void toggleFlag(Pair<Integer, Integer> cellCoordinates) {
        this.grid.getCells().stream()
                .filter(cell -> cell.getCoordinates().equals(cellCoordinates))
                .findFirst()
                .orElseThrow().toggleFlag();
    }

    @Override
    public boolean isAMine(Pair<Integer, Integer> cellCoordinates) {
        return this.grid.getMines().contains(this.grid.getCellFromCoordinates(cellCoordinates));
    }

    @Override
    public int getAdjacentMinesCounter(Pair<Integer, Integer> cellCoordinates) {
       Cell targetCell = this.grid.getCells().stream()
                .filter(cell -> cell.getCoordinates().equals(cellCoordinates))
                .findFirst()
                .orElseThrow();
        return targetCell.getAdjacentMinesCounter();

    }

    @Override
    public boolean isThereVictory() {
        return this.grid.getCells().stream()
                .filter(cell -> !cell.isAMine())
                .allMatch(Cell::isClicked);
    }

    @Override
    public boolean isGameOver() {
        return this.grid.getCells().stream()
                .filter(Cell::isAMine)
                .anyMatch(Cell::isClicked);
    }



}
