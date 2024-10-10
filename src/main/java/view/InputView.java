package view;

import java.util.InputMismatchException;
import java.util.Scanner;
import util.Errors;

public class InputView {

    private Scanner scanner;

    public int getUserIntegerInput() {
        try {
            scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(Errors.INPUT_IS_NOT_INTEGER);
        }
    }


}
