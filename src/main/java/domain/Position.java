package domain;

public class Position {
    private final int value;

    public Position(int value) {
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