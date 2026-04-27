package view;
import constants.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;
    private final String DELIMITER = ",";

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getSingleIntegerFromUserAfterShowingAScript(String script) {
        System.out.println(script);
        String userInput = scanner.nextLine();
        return convertStringToInteger(userInput);
    }

    public String getStringFromUserAfterShowingScript(String script) {
        System.out.println(script);
        String userInput = scanner.nextLine();
        return userInput.strip();
    }

    protected int convertStringToInteger(String stringToConvert) {
        try {
            return Integer.parseInt(stringToConvert);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER);
        }
    }

    public List<String> getListOfStringAfterShowingScript(String script) {
        System.out.println(script);
        return this.parseByDelimiter(scanner.nextLine());
    }

    protected List<String> parseByDelimiter(String userInput) {
        List<String> result = new ArrayList<String>();

        for (String x: userInput.split(this.DELIMITER)) {
            String strippedName = x.strip();
            result.add(strippedName);
        }

        return result;
    }
}