package Model;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SplitMethod {
    protected static List<String> split(String input) {

        final Pattern DELIMITER = Pattern.compile(",");

        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        return DELIMITER.splitAsStream(input)
                .map(String::trim) // 양쪽 공백 제거
                .filter(name -> !name.isEmpty()) // 빈 값 제거 (예: "neo,,brie")
                .collect(Collectors.toList());
    }
}
