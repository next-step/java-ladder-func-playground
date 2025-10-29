package view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public int getInputCol(){
        return scanner.nextInt();
    }

    public int getInputRow(){
        return scanner.nextInt();
    }
}
