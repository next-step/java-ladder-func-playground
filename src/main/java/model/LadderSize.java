package model;

public class LadderSize {
    private final int height;
    private final int width;

    public LadderSize(int width, int height) {
        this.height = height;
        this.width = width;
    }

    public int height() {
        return height;
    }
}
