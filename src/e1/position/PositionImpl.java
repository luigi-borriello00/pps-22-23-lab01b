package e1.position;

import e1.Pair;

import java.util.Objects;

public class PositionImpl implements Position {
    private Pair<Integer, Integer> position;

    public PositionImpl(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    @Override
    public void setPosition(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public boolean equals(Position pos) {
        return this.getPosition().equals(pos.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}

