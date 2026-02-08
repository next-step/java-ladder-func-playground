package view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int readLadderValue() {
        String value = scanner.nextLine();
        return validateInputNumeric(value);
    }

    private int validateInputNumeric(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

}
