package view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String VALUES_PARSER = ",";

    public int readLadderValue() {
        String value = scanner.nextLine();
        return validateInputNumeric(value);
    }

    public List<String> readPlayerNames() {
        String values = scanner.nextLine();
        return List.of(values.split(VALUES_PARSER));
    }

    public List<String> readGameRewards() {
        String values = scanner.nextLine();
        return List.of(values.split(VALUES_PARSER));
    }

    public String readPlayerNameForResult() {
        return scanner.nextLine();
    }

    private int validateInputNumeric(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

}
