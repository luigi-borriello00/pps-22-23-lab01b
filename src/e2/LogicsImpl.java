package e2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LogicsImpl implements Logics {

    private final int boardSize;
    private List<Pair<Integer,Integer>> bombs = new ArrayList<>();
    private final List<Pair<Integer,Integer>> clicked = new ArrayList<>();

    public LogicsImpl(int size, int numberOfBombs) {
        if(numberOfBombs > size*size){
            throw new IllegalArgumentException("Number of bombs cannot be greater than the number of cells in the board");
        }
        this.boardSize = size;
        this.setBombs(numberOfBombs);
    }

    @Override
    public void setBombs(int numberOfBombs) {
        this.bombs = Stream.generate(() -> new Pair<>((int)(Math.random()*this.boardSize),(int)(Math.random()*this.boardSize)))
                .distinct()
                .limit(numberOfBombs)
                .toList();
    }

    @Override
    public int getNumberOfBombs() {
        return this.bombs.size();
    }

    @Override
    public boolean isThisCellABomb(Pair<Integer, Integer> cell) {
        return this.bombs.contains(cell);
    }

    @Override
    public boolean isThereVictory() {
        return this.clicked.size() == this.boardSize*this.boardSize - this.bombs.size();
    }

    @Override
    public List<Pair<Integer, Integer>> getBombsList() {
        return this.bombs;
    }

    @Override
    public void click(Pair<Integer, Integer> cell) {
        if(!this.isThisCellABomb(cell)){
            this.clicked.add(cell);
        }
    }
}
