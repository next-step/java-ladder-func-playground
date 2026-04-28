package domain;

public class LadderWidth {
    private static final int MINIMUM_WIDTH = 2;
    private static final String ERROR_MESSAGE = "사다리 폭은 2 이상이어야 합니다.";

    private final int value;

    public LadderWidth(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MINIMUM_WIDTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }

    public int getIntervalCount() {
        return value - 1;
    }

}
