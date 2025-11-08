package view;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public int getWidthAndHeight() {
        return Integer.parseInt(scanner.nextLine());
    }

    public Scanner getScanner() {
        return scanner;
    }

    public List<String> split(String input) {

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
