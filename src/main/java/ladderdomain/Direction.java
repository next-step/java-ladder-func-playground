package ladderdomain;

import java.util.List;

public enum Direction {

    RIGHT(1, (index, connections) ->
            index < connections.size() && connections.get(index).hasRight()
    ),

    LEFT(-1, (index, connections) ->
            index > 0 && connections.get(index - 1).hasRight()
    ),

    STAY(0, (index, connections) -> true);

    private final int offset;
    private final MoveCondition condition;

    Direction(int offset, MoveCondition condition) {
        this.offset = offset;
        this.condition = condition;
    }

    public boolean canMove(int index, List<Connection> connections) {
        return condition.test(index, connections);
    }

    public int move(int index) {
        return index + offset;
    }

    public static Direction of(int index, List<Connection> connections) {
        return findCanMove(index, connections);
    }

    private static Direction findCanMove(int index, List<Connection> connections) {
        return List.of(RIGHT, LEFT).stream()
                .filter(direction -> direction.canMove(index, connections))
                .findFirst()
                .orElse(STAY);
    }

}
