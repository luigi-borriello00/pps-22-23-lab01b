package e1.position;


import e1.Pair;

public class PiecePosition extends Pair<Integer, Integer> {

    public PiecePosition(Integer integer, Integer integer2) {
        super(integer, integer2);
    }

    public static PiecePosition getRandomPosition(int chessboard) {
        return new PiecePosition((int) (Math.random() * chessboard), (int) (Math.random() * chessboard));
    }

    public boolean isOnBoard(int chessboardSize) {
        return this.getX() >= 0 && this.getX() < chessboardSize && this.getY() >= 0 && this.getY() < chessboardSize;
    }

    public boolean equals(Pair<Integer, Integer> other) {
        return this.getX().equals(other.getX()) && this.getY().equals(other.getY());

    }


}
