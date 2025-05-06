package domain;

public record LadderHeight(int height) {

    private static final int MINIMUM_HEIGHT = 1;

    public LadderHeight {
        validate(height);
    }

    private static void validate(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("높이는 1 이상이어야 합니다.");
        }
    }
}
