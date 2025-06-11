package ladder;

public record Row(int value) {
    private static final int MIN_ROW = 1;

    public Row {
        if (value < MIN_ROW) {
            throw new IllegalArgumentException(
                    "사다리의 높이는 %d 이상이어야 합니다.".formatted(MIN_ROW)
            );
        }
    }

    public static Row from(int value) {
        return new Row(value);
    }
}
