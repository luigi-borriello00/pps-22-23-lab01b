package e2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LogicsImpl implements Logics {

    private final int boardSize;
    private List<Pair<Integer,Integer>> bombs = new ArrayList<>();

    public LogicsImpl(int size, int numberOfBombs) {
        this.boardSize = size;
        this.setNumberOfBombs(numberOfBombs);
    }

    @Override
    public void setNumberOfBombs(int numberOfBombs) {
        this.bombs = Stream.generate(() -> new Pair<>((int)(Math.random()*this.boardSize),(int)(Math.random()*this.boardSize)))
                .distinct()
                .limit(numberOfBombs)
                .toList();
    }

    @Override
    public int getNumberOfBombs() {
        return this.bombs.size();
    }
}
