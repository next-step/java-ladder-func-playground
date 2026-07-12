package domain;

import java.util.function.BiFunction;

public enum Point {

    // 왼쪽으로 연결됨
    CONNECTED_LEFT(-1, (current, size) -> Math.max(0, current - 1)),
    // 오른쪽으로 연결됨
    CONNECTED_RIGHT(1, (current, size) -> Math.min(size - 1, current + 1)),
    // 양쪽 아무 곳에도 연결되지 않음
    NOT_CONNECTED(0, (current, size) -> current);

    private final int offset;
    private final BiFunction<Integer, Integer, Integer> moveLogic;

    Point(int offset, BiFunction<Integer, Integer, Integer> moveLogic) {
        this.offset = offset;
        this.moveLogic = moveLogic;
    }

    public int move(int currentPosition, int size) {
        return moveLogic.apply(currentPosition, size);
    }
}
