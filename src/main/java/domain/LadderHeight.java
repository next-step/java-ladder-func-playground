package domain;

public class LadderHeight {

    private static final int MINIMUM_HEIGHT = 1;

    private final int height;

    private LadderHeight(int height) {
        this.height = height;
    }

    public static LadderHeight create(int height) {
        validate(height);
        return new LadderHeight(height);
    }

    public int height() {
        return height;
    }

    private static void validate(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("높이는 1 이상이어야 합니다.");
        }
    }
}
