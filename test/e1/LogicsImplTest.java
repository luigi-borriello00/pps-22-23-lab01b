package e1;

import e1.factory.PieceFactory;
import e1.factory.PieceFactoryImpl;
import e1.piece.Piece;
import e1.piece.PieceImpl;
import e1.piece.PiecePosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicsImplTest {

    private Logics logics;

    private final PieceFactory factory = new PieceFactoryImpl();
    private static final int CHESSBOARD_SIZE = 5;
    private final Piece knight = new PieceImpl(this.factory.getKnightStrategy(), new PiecePosition(4,0));
    private final Piece pawn = new PieceImpl(this.factory.getPawnStrategy(), new PiecePosition(0,4));


    @BeforeEach
    void setUp(){
        this.logics = new LogicsImpl(CHESSBOARD_SIZE, this.knight.getPosition(), this.pawn.getPosition(), this.factory.getKnightStrategy());
    }

    @Test
    void testHasPawn(){
        assertFalse(this.logics.hasPawn(0,0));
        assertTrue(this.logics.hasPawn(this.pawn.getPosition().getX(), this.pawn.getPosition().getY()));
    }

    @Test
    void testHasKnight(){
        assertFalse(this.logics.hasKnight(0,0));
        assertTrue(this.logics.hasKnight(this.knight.getPosition().getX(), this.knight.getPosition().getY()));
    }

    @Test
    void testCantKnightHit(){
        assertFalse(this.logics.hit(this.pawn.getPosition().getX(), this.pawn.getPosition().getY()));
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