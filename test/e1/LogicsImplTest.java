package e1;

import e1.factory.PieceFactory;
import e1.factory.PieceFactoryImpl;
import e1.position.Position;
import e1.position.PositionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicsImplTest {

    private static final int CHESSBOARD_SIZE = 5;
    private final Position knightPosition = new PositionImpl(new Pair<>(4,0));
    private final Position pawnPosition = new PositionImpl(new Pair<>(0,4));
    private final PieceFactory factory = new PieceFactoryImpl();
    private Logics logics;


    @BeforeEach
    void setUp(){
        this.logics = new LogicsImpl(CHESSBOARD_SIZE, this.knightPosition.getPosition(), this.pawnPosition.getPosition(), this.factory.getKnightStrategy());
    }

    @Test
    void testHasPawn(){
        assertFalse(this.logics.hasPawn(0,0));
        assertTrue(this.logics.hasPawn(this.pawnPosition.getPosition().getX(), this.pawnPosition.getPosition().getY()));
    }

    @Test
    void testHasKnight(){
        assertFalse(this.logics.hasKnight(0,0));
        assertTrue(this.logics.hasKnight(this.knightPosition.getPosition().getX(), this.knightPosition.getPosition().getY()));
    }

    @Test
    void testCantKnightHit(){
        assertFalse(this.logics.hit(this.pawnPosition.getPosition().getX(), this.pawnPosition.getPosition().getY()));
    }

    @Test
    void testCanKnightHitAfterMultipleMoves(){
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