package e1.factory;

import e1.strategy.PieceStrategy;

public interface PieceFactory {

    public PieceStrategy getKnightStrategy();
}
