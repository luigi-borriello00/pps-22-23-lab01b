package e2.playground;

import e2.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GridImpl implements Grid {

    private final int size;
    private final List<Cell> cells;

    public GridImpl(int size, int numberOfBombs) {
        this.size = size;
        this.cells = new ArrayList<>(size * size);
        this.checkIfNumberOfBombsIsCorrect(numberOfBombs);
        this.createCells();
        this.setBombs(numberOfBombs);

    }

    private void checkIfSizeIsCorrect(int size) {
        if (size < 1)
            throw new IllegalArgumentException("Size must be greater than 0");
    }

    private void checkIfNumberOfBombsIsCorrect(int numberOfBombs) {
        if (numberOfBombs > this.size * this.size)
            throw new IllegalArgumentException("Too many bombs");
    }

    private void createCells() {
        Stream.iterate(0, i -> i + 1)
                .limit(this.size)
                .forEach(i -> Stream.iterate(0, j -> j + 1)
                        .limit(this.size)
                        .forEach(j -> this.cells.add(new CellImpl(new Pair<>(i, j)))));
    }

    private void setBombs(int numberOfBombs) {
        Stream.generate(() -> new Pair<>((int) (Math.random() * this.size), (int) (Math.random() * this.size)))
                .distinct()
                .limit(numberOfBombs)
                .forEach(pair -> this.cells.get(pair.getX() * this.size + pair.getY())
                        .setBomb());

    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public List<Cell> getCells() {
        return this.cells;
    }

    @Override
    public List<Cell> getBombs() {
        return this.cells.stream()
                .filter(Cell::isBomb)
                .toList();
    }

    @Override
    public List<Cell> getClickedCells() {
        return this.cells.stream()
                .filter(Cell::isClicked)
                .toList();
    }

    @Override
    public List<Cell> getAdjacentCells(Cell targetCell) {
        // check also in the edges
        return this.cells.stream()
                .filter(cell -> cell.getCoordinates().getX() >= targetCell.getCoordinates().getX() - 1
                        && cell.getCoordinates().getX() <= targetCell.getCoordinates().getX() + 1
                        && cell.getCoordinates().getY() >= targetCell.getCoordinates().getY() - 1
                        && cell.getCoordinates().getY() <= targetCell.getCoordinates().getY() + 1
                        && !cell.equals(targetCell))
                .toList();
    }

    @Override
    public void checkCombo(Cell targetCell) {
        List<Cell> adjacentCells = this.getAdjacentCells(targetCell);
        if(!targetCell.isBomb()){
            if (adjacentCells.stream().noneMatch(Cell::isBomb)){
                adjacentCells.forEach(Cell::click);
            }
        }
    }

}
