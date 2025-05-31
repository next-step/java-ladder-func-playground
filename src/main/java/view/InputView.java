package view;

import java.util.Scanner;

public final class InputView {

    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
    }

    public static int inputLadderWidth() {
        System.out.println("사다리의 넓이는 몇 인가요?");
        return Integer.parseInt(sc.nextLine());
    }

    public static int inputLadderHeight() {
        System.out.println();
        System.out.println("사다리의 높이는 몇 인가요?");
        return Integer.parseInt(sc.nextLine());
    }
}
