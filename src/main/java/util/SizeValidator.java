package util;

import exception.CustomException;
import exception.ErrorMessage;

public class SizeValidator {

    private static final int ZERO = 0;

    public static void validateNotNegative(int value) {
        if (value < ZERO)
            throw new CustomException(ErrorMessage.NEGATIVE_NUMBER);
    }
}
