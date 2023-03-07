package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LogicsTest {

    private final int size = 100;
    private final int numberOfBombs = 101;
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

}