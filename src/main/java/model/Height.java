package model;

public class Height {
    private static final int MIN_HEIGHT = 2;

    private final int value;

    public Height(int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 2 이상이여야 합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
