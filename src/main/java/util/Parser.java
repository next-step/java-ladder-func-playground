package util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private Parser() {
    }

    public static List<String> parseStringDelimiter(String str, char delimiter) {
        return Arrays.stream(str.split("\\s*" + delimiter + "\\s*"))
                .toList();
    }
}
