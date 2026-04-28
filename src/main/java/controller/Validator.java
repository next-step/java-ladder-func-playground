package controller;

import constant.ErrorMessage;

public class Validator {

    public int validateLadderSpec(String spec) {
        int specInt = validateInteger(spec);
        validatePositive(specInt);
        return specInt;
    }

    private int validateInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INTEGER.getMessage());
        }
    }

    private void validatePositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_NUMBER.getMessage());
        }
    }
}
