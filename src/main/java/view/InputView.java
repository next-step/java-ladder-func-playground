package view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);
    public int getWidthAndHeight()
    {
        return scanner.nextInt();
    }

    public Scanner getScanner() {
        return scanner;
    }
}
