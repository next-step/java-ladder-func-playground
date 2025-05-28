package config;

public class GameConfig {
    private final int width;
    private final int height;

    public GameConfig(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
