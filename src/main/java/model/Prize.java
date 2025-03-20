package model;

import exception.ExceptionMessage;

public class Prize {

    private final String value;

    public Prize(String value) {
        validateValue(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validateValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.RESULT_NOT_NULL_OR_EMPTY.getMessage());
        }
    }
}
