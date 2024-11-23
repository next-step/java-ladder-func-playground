package model.ladder;

public enum LadderMove {
    RIGHT(1),
    LEFT(-1),
    DOWN(0);

    private final int offset;

    LadderMove(int offset) {
        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }
}
