package io.suhan.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_DELIMITER = ",";

    public static List<String> getParticipants() {
        System.out.println();
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 " + INPUT_DELIMITER + "로 구분하세요)");

        return Arrays.asList(scanner.nextLine().split(INPUT_DELIMITER));
    }

    public static List<String> getOutcomes() {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 " + INPUT_DELIMITER + "로 구분하세요)");

        return Arrays.asList(scanner.nextLine().split(INPUT_DELIMITER));
    }

    public static int getLadderHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return scanner.nextInt();
    }

    public static String getParticipantForResult() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");

        return scanner.nextLine();
    }
}
