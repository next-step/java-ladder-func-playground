package ladder.view;

import java.util.Scanner;

import ladder.message.ConsoleMessage;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static Integer getWidth() {
        System.out.println(ConsoleMessage.LADDER_WIDTH.getMessage());
        return scanner.nextInt();
    }

    public static Integer getHeight() {
        System.out.println(ConsoleMessage.LADDER_HEIGHT.getMessage());
        return scanner.nextInt();
    }
}
