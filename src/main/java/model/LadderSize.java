package model;

public class LadderSize {
    private final int height;
    private final int width;

    public LadderSize(int height, int width) {
        if (height <= 0 || width <= 1) {
            throw new IllegalArgumentException("넓이는 2 이상이여야 하고, 높이는 1 이상이여야 합니다.");
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
