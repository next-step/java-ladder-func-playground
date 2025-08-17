package model;

import exception.CustomException;
import exception.ErrorMessage;

public class Player {

    private final String name;

    private static final int MAX_NAME_LENGTH = 5;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        validateNameEmpty(name);
        validateNameLength(name);
    }

    private void validateNameEmpty(String name) {
        if (name == null || name.isBlank()) {
            throw new CustomException(ErrorMessage.EMPTY_NAME);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new CustomException(ErrorMessage.NAME_LENGTH);
        }
    }
}
