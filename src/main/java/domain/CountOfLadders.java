package domain;

import util.Errors;

public record CountOfLadders(int value) {

    public CountOfLadders {
        validate(value);
    }

    private void validate(int value) {
        validateIsNotEmpty(value);
    }

    private void validateIsNotEmpty(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(Errors.LADDERS_MUST_CONTAINS_LEAST_ONE_LADDER);
        }
    }
}
