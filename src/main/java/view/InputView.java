package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String players = scanner.nextLine();
        return parseResults(players);
    }

    public List<String> inputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        return parseResults(input);
    }

    public int getMaxLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = scanner.nextLine();
        return parseLadderHeight(input);
    }

    public String getTargetPlayerName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

    private List<String> parseResults(String input) {
        throwIfNamesIsNullOrEmpty(input);

        return Arrays.stream(input.trim().split(","))
                .map(String::trim)
                .toList();
    }

    private int parseLadderHeight(String input) {
        try {
            return Integer.parseInt(String.valueOf(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 숫자여야 합니다.");
        }
    }

    private void throwIfNamesIsNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 null이거나 비어있을 순 없습니다.");
        }
    }
}
