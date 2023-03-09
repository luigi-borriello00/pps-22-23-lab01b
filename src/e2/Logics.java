package e2;
import e2.playground.Grid;

import java.util.List;

public interface Logics {


    List<Pair<Integer, Integer>> getAllCells();
    List<Pair<Integer, Integer>> getClickedCells();
    List<Pair<Integer, Integer>> getFlaggedCells();
    List<Pair<Integer, Integer>> getBombsCells();

    boolean clickCell(Pair<Integer, Integer> coordinates);

    void toggleFlag(Pair<Integer, Integer> coordinates);

    int getAdjacentBombs(Pair<Integer, Integer> coordinates);

    boolean isThereVictory();

    boolean isGameOver();
}
