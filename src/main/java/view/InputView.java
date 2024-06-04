package view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public int widthLadder() {
        System.out.println("사다리 넓이는 몇 개인가요? ");
        return scanner.nextInt();
    }

    public int heightLadder() {
        System.out.println("사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}