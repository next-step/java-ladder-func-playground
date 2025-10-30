package view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public int getInputCol() {
        return scanner.nextInt();
    }

    public int getInputRow() {
        return scanner.nextInt();
    }

    public String getInputPlayers() {
        return scanner.nextLine();
    }

    public String getInputSelectedPlayer() {
        return scanner.nextLine();
    }

    public String getInputPrizes() {
        return scanner.nextLine();
    }
}
