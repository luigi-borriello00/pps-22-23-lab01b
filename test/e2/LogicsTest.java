package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LogicsTest {

    private final int size = 10;
    private final int numberOfBombs = 90;
    private Logics logics;

    @BeforeEach
    void setUp() {
        this.logics = new LogicsImpl(this.size, this.numberOfBombs);
    }


    @Test
    void checkNumberOfBombs(){
        assertEquals(numberOfBombs, this.logics.getNumberOfBombs());
        assertNotEquals(numberOfBombs+1, this.logics.getNumberOfBombs());
    }

    @Test
    void checkIfThereAreDuplicates(){
        assertEquals(this.numberOfBombs, this.logics.getNumberOfBombs());
    }

    @Test
    void testWhenBombsAreMoreThenBoardSize(){
        assertThrows(IllegalArgumentException.class, () -> new LogicsImpl(this.size, this.size*this.size+1));
    }

    @Test
    void testIfNotClickingOnBombDoesNotEndTheGame(){
        final List<Pair<Integer, Integer>> bombs = this.logics.getBombsList();
        // generate a pair that is not in this.logics.getBombsList()
        final Pair<Integer, Integer> notABomb = Stream.generate(() -> new Pair<>((int)(Math.random()*this.size),(int)(Math.random()*this.size)))
                .filter(p -> !bombs.contains(p))
                .findFirst()
                .get();

        final boolean aMineWasFound = this.logics.isThisCellABomb(notABomb);
        assertFalse(aMineWasFound);
    }

    @Test
    void testIfClickingOnBombEndsTheGame(){
        final Pair<Integer, Integer> bomb = this.logics.getBombsList().get(0);
        final boolean aMineWasFound = this.logics.isThisCellABomb(bomb);
        assertTrue(aMineWasFound);
    }

    @Test
    void testIfVictoryIsAchieved(){
        // implement this using stream
        final List<Pair<Integer, Integer>> bombs = this.logics.getBombsList();
        Stream.generate(() -> new Pair<>((int)(Math.random()*this.size),(int)(Math.random()*this.size)))
                .filter(p -> !bombs.contains(p))
                .limit(this.size*this.size - this.numberOfBombs)
                .forEach(p -> this.logics.click(p));
        assertTrue(this.logics.isThereVictory());
    }


}