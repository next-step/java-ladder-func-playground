package utils;

import java.util.List;

public class InputParser {
    public static List<String> parseByComma(String input) {
        return List.of(input.split(","));
    }
}
