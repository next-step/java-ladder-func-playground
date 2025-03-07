package domain;

public class Position {
    private final int value;

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Position은 음수일 수 없습니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Position moveLeft() {
        return new Position(value - 1);
    }

    public Position moveRight() {
        return new Position(value + 1);
    }
}
