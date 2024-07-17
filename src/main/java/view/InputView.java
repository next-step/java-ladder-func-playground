package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int printWidthCount() {
        System.out.println("사다리의 넓이는 몇 개 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int printHeightCount() {
        System.out.println("사다리의 높이는 몇 개 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }
}
