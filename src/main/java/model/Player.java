package model;

import exception.ExceptionMessage;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;
    private final String value;

    public Player(String value) {
        validateValues(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validateValues(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NULL_OR_EMPTY_INPUT.getMessage());
        }

        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.PLAYER_NAME_MAX_LENGTH_EXCEEDED.getMessage());
        }
    }
}
