package e1.factory;

import e1.Pair;
import e1.strategy.LogicStrategy;

public class LogicsFactoryImpl implements LogicsFactory
{
    @Override
    public LogicStrategy getKnightStrategy()
    {
        return new LogicStrategy(){

            @Override
            public boolean canBeMoved(int x, int y, int posX, int posY, int size) {
                if (x<0 || y<0 || x >= size || y >= size) {
                    throw new IndexOutOfBoundsException();
                }
                // Below a compact way to express allowed moves for the knight
                int newX = x-posX;
                int newY = y-posY;
                return newX != 0 && newY != 0 && Math.abs(newX) + Math.abs(newY) == 3;
            }
        };
    }
}
