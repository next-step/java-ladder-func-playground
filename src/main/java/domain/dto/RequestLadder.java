package domain.dto;

public record RequestLadder(
        int width,
        int height
) {

    static final int MIN_LADDER_SIZE = 2;
    static final int MAX_LADDER_SIZE = 24;

    public RequestLadder {
        validateLadderSize(width, height);
    }

    private void validateLadderSize(final int width, final int height) {
        validateWidthSize(width);
        validateHeightSize(height);
    }

    private void validateWidthSize(final int width) {
        if (width < MIN_LADDER_SIZE || MAX_LADDER_SIZE < width) {
            throw new IllegalArgumentException(
                    "사다리의 넓이는 %s 이상 %s 이하여야 합니다.".formatted(MIN_LADDER_SIZE, MAX_LADDER_SIZE));
        }
    }

    private void validateHeightSize(final int height) {
        if (height < MIN_LADDER_SIZE || MAX_LADDER_SIZE < height) {
            throw new IllegalArgumentException(
                    "사다리의 높이는 %s 이상 %s 이하여야 합니다.".formatted(MIN_LADDER_SIZE, MAX_LADDER_SIZE));
        }
    }
}
