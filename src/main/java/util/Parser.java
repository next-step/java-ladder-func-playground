package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import exception.CustomException;
import exception.ErrorMessage;

public class Parser {

    public static List<String> parseStringToList(String str) {
        if (str == null) {
            throw new CustomException(ErrorMessage.NULL_INPUT_STRING);
        }

        return Arrays.stream(str.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
    }
}
