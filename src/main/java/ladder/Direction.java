package ladder;

public enum Direction {
    LEFT(-1), RIGHT(1), DOWN(0);

    private final int step;

    Direction(int step) {
        this.step = step;
    }

    public int move(int position) {
        return position + step;
    }
}

