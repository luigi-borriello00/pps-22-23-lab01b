package e1.position;

import e1.Pair;

public interface Position {

    /**
     * @return the position
     *
     */
    Pair<Integer, Integer> getPosition();

    /**
     * @param position the position to set
     */
    void setPosition(Pair<Integer, Integer> position);

    boolean equals(Position pos);
}
