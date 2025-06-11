package domain.ladder;

public enum Direction {
    LEFT(-1),
    DOWN(0),
    RIGHT(1)
    ;

    private final int offset;

    Direction(final int offset) {
        this.offset = offset;
    }

    public int moveFrom(final int index) {
        return index + offset;
    }
}
