package e2;
import java.util.List;

public interface Logics {

    void setBombs(int numberOfBombs);

    int getNumberOfBombs();

    List<Pair<Integer, Integer>> getBombsList();
}
