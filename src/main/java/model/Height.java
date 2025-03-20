package model;

import exception.ExceptionMessage;

public class Height {
    private static final int MIN_HEIGHT = 2;

    private final int value;

    public Height(int value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException(ExceptionMessage.LADDER_HEIGHT_MIN_VALUE.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
