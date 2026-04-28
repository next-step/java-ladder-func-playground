package view;

import java.util.Scanner;

public class InputView {
    private static final String REQUEST_WIDTH_MESSAGE = "사다리의 넓이는 몇 개인가요?";
    private static final String REQUEST_HEIGHT_MESSAGE = "사다리의 높이는 몇 개인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    public int readWidth() {
        System.out.println(REQUEST_WIDTH_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public int readHeight() {
        System.out.println(REQUEST_HEIGHT_MESSAGE);
        return Integer.parseInt(SCANNER.nextLine());
    }
}