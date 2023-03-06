package e1.strategy;

import e1.Logics;
import e1.Pair;

public class LogicsWithStrategyImpl implements Logics {
    private final LogicStrategy logicStrategy;
    private final Pair<Integer,Integer> pawn;
    private Pair<Integer,Integer> knight;


    public LogicsWithStrategyImpl(LogicStrategy knightStrategy, int size) {
        this.logicStrategy = knightStrategy;
        this.pawn = new Pair<>(0,4);
        this.knight = new Pair<>(4,0);
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
