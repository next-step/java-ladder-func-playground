package controller;

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
            throw new IllegalArgumentException("정수를 입력하세요.");
        }
    }

    private void validatePositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("0보다 큰 값을 입력하세요.");
        }
    }
}
