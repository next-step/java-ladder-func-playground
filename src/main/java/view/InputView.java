package view;
import constants.ErrorMessage;

import java.util.Scanner;

public class InputView {
    Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getSingleIntegerFromUserAfterShowingAScript(String script) {
        System.out.println(script);
        String userInput = scanner.nextLine();
        return convertStringToInteger(userInput);
    }

    protected int convertStringToInteger(String stringToConvert) {
        try {
            return Integer.parseInt(stringToConvert);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER);
        }
    }
}