package ladder;

public record Height(int height) {

    public Height {
        if (height < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }

    public static Height from(int height) {
        return new Height(height);
    }
}
