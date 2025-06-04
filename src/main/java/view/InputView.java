package view;

import java.util.Scanner;

public final class InputView {

    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
    }

    public static String inputLadderWidth() {
        System.out.println("사다리의 넓이는 몇 인가요?");
        return sc.nextLine();
    }

    public static String inputLadderHeight() {
        System.out.println();
        System.out.println("사다리의 높이는 몇 인가요?");
        return sc.nextLine();
    }
}
