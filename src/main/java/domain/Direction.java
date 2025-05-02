package domain;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.IntUnaryOperator;

public enum Direction {
    LEFT(position -> position - 1, (points, position) -> position > 0 && points.get(position - 1)),
    RIGHT(position -> position + 1, (points, position) -> position < points.size() && points.get(position)),
    DOWN(position -> position, (points, position) -> true);

    private final IntUnaryOperator moveOperator;
    private final BiPredicate<List<Boolean>, Integer> canMovePredicate;


    Direction(IntUnaryOperator moveOperator, BiPredicate<List<Boolean>, Integer> canMovePredicate) {
        this.moveOperator = moveOperator;
        this.canMovePredicate = canMovePredicate;
    }

    public boolean canMove(List<Boolean> points, int position) {
        return canMovePredicate.test(points, position);
    }

    public int move(int position) {
        return moveOperator.applyAsInt(position);
    }
}
