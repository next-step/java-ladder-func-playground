package utils;

import java.util.List;

public class InputParser {
    public static List<String> parseByComma(String input) {
        List<String> split = List.of(input.split(","));
        for (String name : split) {
            validate(name);
        }
        return split;
    }

    private static void validate(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("입력이 null이거나 공백으로만 구성될 수 없습니다.");
        }
    }
}
