package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
