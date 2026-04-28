package domain;

public class LadderHeight {
    private static final int MINIMUM_HEIGHT = 1;
    private static final String ERROR_MESSAGE = "사다리 높이는 1 이상이어야 합니다.";

    private final int value;

    public LadderHeight(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }
}
