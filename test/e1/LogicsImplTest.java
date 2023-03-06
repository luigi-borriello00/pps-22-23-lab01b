package e1;

import e1.factory.LogicsFactory;
import e1.factory.LogicsFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicsImplTest {

    private static final int SIZE = 5;
    private final Pair<Integer, Integer> knightPosition = new Pair<>(4,0);
    private final Pair<Integer, Integer> pawnPosition = new Pair<>(0,4);

    private LogicsFactory factory = new LogicsFactoryImpl();
    private Logics logics;


    @BeforeEach
    void setUp(){
        this.logics = new LogicsImpl(SIZE, this.knightPosition, this.pawnPosition, this.factory.getKnightStrategy());
    }

    @Test
    void testHasPawn(){
        assertFalse(this.logics.hasPawn(0,0));
        assertTrue(this.logics.hasPawn(this.pawnPosition.getX(), this.pawnPosition.getY()));
    }

    @Test
    void testHasKnight(){
        assertFalse(this.logics.hasKnight(0,0));
        assertTrue(this.logics.hasKnight(this.knightPosition.getX(), this.knightPosition.getY()));
    }

    @Test
    void testCantKnightHit(){
        assertFalse(this.logics.hit(this.pawnPosition.getX(), this.pawnPosition.getY()));
    }

    @Test
    void testCanKnightHit(){
        assertFalse(this.logics.hit(3,2));
        assertFalse(this.logics.hit(1,1));
        assertFalse(this.logics.hit(2, 3));
        assertTrue(this.logics.hit(0,4));
    }

    @Test
    void testCantHitOutsideBoard(){
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(-1,0));
        assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hit(0,-1));
    }





}