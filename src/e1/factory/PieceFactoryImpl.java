package e1.factory;

import e1.position.PiecePosition;
import e1.strategy.PieceStrategy;

public class PieceFactoryImpl implements PieceFactory
{
    @Override
    public PieceStrategy getKnightStrategy()
    {
        return new PieceStrategy(){

            @Override
            public boolean canBeMoved(PiecePosition newPosition, PiecePosition actualPosition, int size) {
                if (!newPosition.isOnBoard(size)) {
                    throw new IndexOutOfBoundsException();
                }
                // Below a compact way to express allowed moves for the knight
                int newX = newPosition.getX() - actualPosition.getX();
                int newY = newPosition.getY() - actualPosition.getY();
                return newX != 0 && newY != 0 && Math.abs(newX) + Math.abs(newY) == 3;
            }
        };
    }
}
