package view;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    private InputParser() {
    }

    public static List<String> parseCommaSeparated(String input) {
        return Arrays.stream(input.strip().split(","))
                .map(String::strip)
                .toList();
    }
}
