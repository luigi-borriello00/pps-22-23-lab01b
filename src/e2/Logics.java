package e2;

import java.util.List;

public interface Logics {


    List<Pair<Integer, Integer>> getAllCells();
    List<Pair<Integer, Integer>> getClickedCells();
    List<Pair<Integer, Integer>> getFlaggedCells();
    List<Pair<Integer, Integer>> getMines();

    void clickCell(Pair<Integer, Integer> cellCoordinates);
    void toggleFlag(Pair<Integer, Integer> cellCoordinates);
    boolean isAMine(Pair<Integer, Integer> cellCoordinates);
    int getAdjacentMinesCounter(Pair<Integer, Integer> cellCoordinates);
    boolean isThereVictory();

    boolean isGameOver();

}
