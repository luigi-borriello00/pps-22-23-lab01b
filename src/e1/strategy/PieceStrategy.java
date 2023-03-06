package e1.strategy;

public interface PieceStrategy {

    /**
     * @param newX the new x position
     * @param newY the new y position
     * @param actualX the actual x position
     * @param actualY the actual y position
     * @param size the size of the board
     * @return true if the piece can be moved to the new position
     */
    boolean canBeMoved(int newX, int newY, int actualX, int actualY, int size);

}
