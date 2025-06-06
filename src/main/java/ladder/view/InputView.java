package ladder.view;

import java.util.Scanner;

public class InputView {

    public int inputWidth() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("사다리의 넓이는 몇 개인가요?\n: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int inputHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("사다리의 높이는 몇 개인가요?\n: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
