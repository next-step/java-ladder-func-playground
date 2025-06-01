package domain.dto;

public record RequestLadder(
        int width,
        int height
) {

    public static final int MIN_LADDER_SIZE = 2;

    public RequestLadder {
        validateLadderSize(width, height);
    }

    private void validateLadderSize(final int width, final int height) {
        if (width < MIN_LADDER_SIZE || height < MIN_LADDER_SIZE) {
            throw new IllegalArgumentException("사다리의 넓이와 높이는 최소 %s어야 합니다.".formatted(MIN_LADDER_SIZE));
        }
    }
}
