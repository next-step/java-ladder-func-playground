package ladder.view;

import java.util.List;
import java.util.Scanner;

import ladder.message.ConsoleMessage;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static Integer getHeight() {
        System.out.println();
        System.out.println(ConsoleMessage.LADDER_HEIGHT.getMessage());

        return scanner.nextInt();
    }

    public static List<String> getNames() {
        System.out.println(ConsoleMessage.INPUT_NAME.getMessage());

        return List.of(scanner.nextLine().split(","));
    }

    public static List<String> getResult() {
        System.out.println();
        System.out.println(ConsoleMessage.INPUT_RESULT.getMessage());

        return List.of(scanner.nextLine().split(","));
    }

    public static String wantResult() {
        System.out.println();
        System.out.println(ConsoleMessage.RESULT_TARGET.getMessage());

        return scanner.next();
    }
}
