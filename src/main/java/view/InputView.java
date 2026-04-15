package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public int readWidth(){
        System.out.println("사다리의 넓이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public int readHeight(){
        System.out.println("사다리의 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }
}
