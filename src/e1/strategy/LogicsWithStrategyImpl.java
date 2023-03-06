package e1.strategy;

import e1.Logics;
import e1.Pair;

import java.util.Random;

public class LogicsWithStrategyImpl implements Logics {
    private final LogicStrategy logicStrategy;
    private final Pair<Integer,Integer> pawn;
    private Pair<Integer,Integer> knight;
    private final Random random = new Random();
    private final int size;


    public LogicsWithStrategyImpl(LogicStrategy knightStrategy, int size, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition) {
        this.logicStrategy = knightStrategy;
        this.pawn = pawnPosition;
        this.knight = knightPosition;
        this.size = size;
    }

    public LogicsWithStrategyImpl(LogicStrategy knightStrategy, int size){
        this.logicStrategy = knightStrategy;
        this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();
    }
    private final Pair<Integer,Integer> randomEmptyPosition(){
        Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
        // the recursive call below prevents clash with an existing pawn
        return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }

    @Override
    public boolean hit(int row, int col) {
        if(this.logicStrategy.canBeMoved(row,col,this.knight.getX(),this.knight.getY(),8)){
            this.knight = new Pair<>(row,col);
            return this.pawn.equals(this.knight);
        }
        else {
            return false;
        }
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.knight.equals(new Pair<>(row,col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.pawn.equals(new Pair<>(row,col));
    }
}
