package view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public int getWidthAndHeight() {
        return Integer.parseInt(scanner.nextLine());
    }

        public Scanner getScanner() {
        return scanner;
    }
}
