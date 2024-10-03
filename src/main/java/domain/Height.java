package domain;

import util.Errors;

public record Height(int value) {

    public Height {
        validate(value);
    }

    private void validate(int value) {
        validatePositive(value);
    }

    private void validatePositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(Errors.LADDER_HEIGHT_MUST_BE_POSITIVE);
        }
    }
}
