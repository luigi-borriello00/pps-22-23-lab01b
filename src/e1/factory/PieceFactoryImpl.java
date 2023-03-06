package e1.factory;

import e1.strategy.PieceStrategy;

public class PieceFactoryImpl implements PieceFactory
{
    @Override
    public PieceStrategy getKnightStrategy()
    {
        return new PieceStrategy(){

            @Override
            public boolean canBeMoved(int x, int y, int actualX, int actualY, int size) {
                if (x<0 || y<0 || x >= size || y >= size) {
                    throw new IndexOutOfBoundsException();
                }
                // Below a compact way to express allowed moves for the knight
                int newX = x- actualX;
                int newY = y- actualY;
                return newX != 0 && newY != 0 && Math.abs(newX) + Math.abs(newY) == 3;
            }
        };
    }
}
