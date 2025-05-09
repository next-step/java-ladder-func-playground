package ladderdomain;

import java.util.List;
import java.util.function.Predicate;

public enum Direction {

    RIGHT(
            index -> index < Integer.MAX_VALUE && hasRight(index),
            index -> index + 1
    ),
    LEFT(
            index -> index > 0 && hasRight(index - 1),
            index -> index - 1
    ),
    STAY(
            index -> true,
            index -> index
    );

    private static List<Connection> currentConnections;
    private final Predicate<Integer> condition;
    private final java.util.function.IntUnaryOperator movement;

    Direction(Predicate<Integer> condition, java.util.function.IntUnaryOperator movement) {
        this.condition = condition;
        this.movement = movement;
    }

    public static Direction of(int index, List<Connection> connections) {
        currentConnections = connections;
        for (Direction direction : values()) {
            if (direction != STAY && direction.condition.test(index)) {
                return direction;
            }
        }
        return STAY;
    }

    public int move(int index) {
        return movement.applyAsInt(index);
    }

    private static boolean hasRight(int index) {
        return index >= 0 && index < currentConnections.size() && currentConnections.get(index).hasRight();
    }
}

