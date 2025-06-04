package domain;

public record Width(
        int value
) {

    static final int MIN_LADDER_WIDTH_SIZE = 2;
    static final int MAX_LADDER_WIDTH_SIZE = 24;

    public Width {
        validateWidthSize(value);
    }

    public static Width from(final int value) {
        return new Width(value);
    }

    private void validateWidthSize(final int value) {
        if (value < MIN_LADDER_WIDTH_SIZE || MAX_LADDER_WIDTH_SIZE < value) {
            throw new IllegalArgumentException(
                    "사다리의 넓이는 %s 이상 %s 이하여야 합니다.".formatted(MIN_LADDER_WIDTH_SIZE, MAX_LADDER_WIDTH_SIZE));
        }
    }
}
