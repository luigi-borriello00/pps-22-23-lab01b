package e1.strategy;

public interface LogicStrategy {
    /**
     * Return True if the piece can be moved to (x,y)
     * @param x
     * @param y
     * @return
     */
    boolean canBeMoved(int x, int y, int posX, int posY, int SIZE);

}
