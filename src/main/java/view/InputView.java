package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readLadderWidth(){
        System.out.println("사다리의 넓이는 몇 개인가요?");
        return parseToInt(scanner.nextLine());

    }

    public static int readLadderHeight(){
        System.out.println("사다리의 높이는 몇 개인가요?");
        return parseToInt(scanner.nextLine());
    }

    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input.strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
}
