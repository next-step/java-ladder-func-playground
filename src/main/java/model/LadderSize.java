package model;

public class LadderSize {
    private final int height;
    private final int width;

    public LadderSize(int width, int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("높이는 1 이상이여야 합니다.");
        }
        this.height = height;
        this.width = width;
    }

    public int height() {
        return height;
    }

    public int width() {
        return width;
    }
}
