package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import ladder.domain.LadderHeight;
import ladder.domain.LadderResults;
import ladder.domain.Participants;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    private InputView() {}

    private static <T> T input(String message, Supplier<T> supplier) {
        while (true) {
            try {
                System.out.println(message);
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public static Participants inputNames() {
        return input("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)", () -> {
            String input = sc.nextLine();
            if (input == null || input.isBlank()) {
                throw new IllegalArgumentException("참가자 이름을 입력해야 합니다.");
            }
            List<String> names = Arrays.asList(input.split(","));
            return Participants.from(names);
        });
    }

    public static LadderResults inputLadderResults(int participantCount) {
        return input("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)", () -> {
            String input = sc.nextLine();
            if (input == null || input.isBlank()) {
                throw new IllegalArgumentException("실행 결과는 빈 값일 수 없습니다.");
            }

            List<String> rawResults = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

            return LadderResults.of(rawResults, participantCount);
        });
    }

    public static LadderHeight inputHeight() {
        return input("사다리의 높이는 몇 개인가요?", () -> {
            String input = sc.nextLine();
            return LadderHeight.from(parseToInt(input));
        });
    }

    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

}
