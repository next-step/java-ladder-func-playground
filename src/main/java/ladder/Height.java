package ladder;

public record Height(int height) {
    private static final int MIN_HEIGHT = 1;

    public Height {
        if (height < MIN_HEIGHT ) {
            throw new IllegalArgumentException("사다리의 높이는 "+ MIN_HEIGHT + " 이상이어야 합니다.");
        }
    }

    public static Height from(int height) {
        return new Height(height);
    }
}
