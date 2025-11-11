package view;

import java.util.Scanner;

public class InputView {
    Scanner input = new Scanner(System.in);

    public String readString() {
        return input.nextLine();
    }

    public int readInt() {
        int number = input.nextInt();
        input.nextLine();
        return number;
    }
}

