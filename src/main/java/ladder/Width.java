package ladder;

public record Width(int width) {
    private static final int MIN_WIDTH = 2;

    public Width {
        if (width < MIN_WIDTH) {
            throw new IllegalArgumentException("사다리의 넓이는 " + MIN_WIDTH + " 이상이어야 합니다.");
        }
    }

    public static Width from(int width) {
        return new Width(width);
    }
}
