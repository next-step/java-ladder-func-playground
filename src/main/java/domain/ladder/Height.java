package domain.ladder;

public record Height(
        int value
) {

    private static final int MIN_LADDER_HEIGHT_SIZE = 2;
    private static final int MAX_LADDER_HEIGHT_SIZE = 24;

    public Height {
        validateHeightSize(value);
    }

    public static Height from(final int value) {
        return new Height(value);
    }

    private void validateHeightSize(final int value) {
        if (value < MIN_LADDER_HEIGHT_SIZE || MAX_LADDER_HEIGHT_SIZE < value) {
            throw new IllegalArgumentException(
                    "사다리의 높이는 %s 이상 %s 이하여야 합니다.".formatted(MIN_LADDER_HEIGHT_SIZE, MAX_LADDER_HEIGHT_SIZE));
        }
    }
}
