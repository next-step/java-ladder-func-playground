package ladder;

public record Width(int width) {

    public Width {
        if (width < 2) {
            throw new IllegalArgumentException("사다리의 넓이는 2 이상이어야 합니다.");
        }
    }

    public static Width from(int width) {
        return new Width(width);
    }
}
