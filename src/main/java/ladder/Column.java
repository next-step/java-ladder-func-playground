package ladder;

public record Column(int value) {
    private static final int MIN_COLUMN = 2;

    public Column {
        if (value < MIN_COLUMN) {
            throw new IllegalArgumentException("사다리의 넓이는 " + MIN_COLUMN + " 이상이어야 합니다.");
        }
    }

    public static Column from(int value) {
        return new Column(value);
    }
}
