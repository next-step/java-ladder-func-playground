package domain;

public class LadderSize {

    private final int width;
    private final int height;

    public LadderSize(int width, int height) {
        validatePositiveSize(width, height);
        this.width = width;
        this.height = height;
    }

    private void validatePositiveSize(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("사다리의 너비와 높이는 0보다 커야 합니다.");
        }
    }

    public int getWidth() {
        return width;
    }
}
