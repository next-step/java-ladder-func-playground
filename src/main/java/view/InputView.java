package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_RESULTS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_HEIGHT = "사다리의 높이는 몇 개인가요?";
    public static final String INPUT_TARGET_NAME = "결과를 보고 싶은 사람은?";
    private static final String ERROR_NOT_NUMBER = "숫자를 입력해 주세요.";
    private final Scanner scanner = new Scanner(System.in);

    public List<String> readNames() {
        System.out.println(INPUT_NAMES);
        String[] names = scanner.nextLine().trim().split(",");
        return Arrays.stream(names)
                .toList();
    }

    public List<String> readRewards() {
        System.out.println();
        System.out.println(INPUT_RESULTS);
        String[] results = scanner.nextLine().trim().split(",");
        return Arrays.stream(results)
                .toList();
    }

    public int readHeight() {
        System.out.println();
        System.out.println(INPUT_HEIGHT);
        String input = scanner.nextLine();
        return parseIntInput(input);
    }

    public String readTargetName() {
        System.out.println();
        System.out.println(INPUT_TARGET_NAME);
        return scanner.nextLine();
    }

    private int parseIntInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }
}
