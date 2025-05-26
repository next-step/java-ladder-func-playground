package view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_WIDTH = "사다리의 넓이는 몇 개인가요?";
    private static final String INPUT_HEIGHT = "사다리의 높이는 몇 개인가요?";
    private static final String ERROR_NOT_NUMBER = "숫자를 입력해 주세요.";
    private final Scanner scanner = new Scanner(System.in);

    public int readWidth() {
        System.out.println(INPUT_WIDTH);
        String input = scanner.nextLine();
        return parseIntInput(input);
    }

    public int readHeight() {
        System.out.println();
        System.out.println(INPUT_HEIGHT);
        String input = scanner.nextLine();
        return parseIntInput(input);
    }

    private int parseIntInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }
}
