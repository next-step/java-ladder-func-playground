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

    private void validateValues(String values) {
        if (values.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.PLAYER_NAME_TOO_LONG.getMessage());
        }
    }
}
