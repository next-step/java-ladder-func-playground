package model;

public class LadderSize {
    private final int height;
    private final int width;

    public LadderSize(int width, int height) {
        validateHeight(height);
        this.height = height;
        this.width = width;
    }

    private void validateHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
    }

    public int height() {
        return height;
    }
}
