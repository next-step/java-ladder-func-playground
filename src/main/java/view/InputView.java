package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NEW_LINE = System.lineSeparator();

    public static String readName(){
        System.out.print("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)" + NEW_LINE +
                "※ 중복된 이름은 '이름_1', '이름_2' 형식으로 입력해주세요." + NEW_LINE);
        return scanner.nextLine();
    }

//    public static int readLadderWidth(){
//        System.out.println("사다리의 넓이는 몇 개인가요?");
//        return parseToInt(scanner.nextLine());
//
//    }

    public static String readPrize(){
        System.out.print(NEW_LINE + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)" + NEW_LINE);
        return scanner.nextLine();
    }

    public static int readLadderHeight(){
        System.out.print(NEW_LINE + "최대 사다리 높이는 몇 개인가요?" + NEW_LINE);
        return parseToInt(scanner.nextLine());
    }

    public static String readResultName(){
        System.out.print(NEW_LINE + "결과를 보고 싶은 사람은?" + NEW_LINE);
        return scanner.nextLine();
    }

    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input.strip());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
}
