package e2.playground;

import e2.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GridImpl implements Grid{

    private final int size;
    private final List<Cell> cells;

    public GridImpl(int size, int numberOfBombs) {
        this.size = size;
        this.cells = new ArrayList<>(size*size);
        if(numberOfBombs > size*size)
            throw new IllegalArgumentException("Too many bombs");
        this.createCells();
        this.setBombs(numberOfBombs);

    }

    private void createCells(){
        Stream.iterate(0, i -> i+1)
                .limit(this.size)
                .forEach(i -> Stream.iterate(0, j -> j+1)
                        .limit(this.size)
                        .forEach(j -> this.cells.add(new CellImpl(new Pair<>(i,j)))));
    }
    private void setBombs(int numberOfBombs) {
        Stream.generate(() -> new Pair<>((int)(Math.random()*this.size),(int)(Math.random()*this.size)))
                .distinct()
                .limit(numberOfBombs)
                .forEach(pair -> this.cells.get(pair.getX()*this.size + pair.getY())
                        .setBomb());

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Cell getCell(Pair<Integer, Integer> coordinates) {
        return null;
    }

    @Override
    public List<Cell> getCells() {
        return this.cells;
    }

    @Override
    public void click(Cell coordinates) {

    }

    @Override
    public List<Cell> getClickedCells() {
        return null;
    }

    @Override
    public List<Cell> getBombs() {
        return this.cells.stream()
                .filter(Cell::isBomb)
                .toList();
    }

    @Override
    public List<Cell> getAdjacentCells(Pair<Integer, Integer> coordinates) {
        return null;
    }

}
