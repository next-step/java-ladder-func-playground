package View;

import Domain.Name;
import Domain.Player;
import Domain.Players;
import Domain.Result;
import Domain.Results;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static Players readPlayersUntilValid() {
        while (true) {
            try {
                System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
                List<String> names = Arrays.stream(scanner.nextLine().split(","))
                        .map(String::trim)
                        .toList();
                validatePlayerInput(names);
                return new Players(names.stream()
                        .map(Name::new)
                        .map(Player::new)
                        .toList());
            } catch (Exception e) {
                System.out.println("[입력 오류] " + e.getMessage());
            }
        }
    }

    public static Results readResultsUntilValid(int expectedSize) {
        while (true) {
            try {
                System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
                List<String> values = Arrays.stream(scanner.nextLine().split(","))
                        .map(String::trim)
                        .toList();
                validateResultInput(values, expectedSize);
                return new Results(values.stream().map(Result::new).toList());
            } catch (Exception e) {
                System.out.println("[입력 오류] " + e.getMessage());
            }
        }
    }

    public static int readHeightUntilValid() {
        while (true) {
            try {
                System.out.println("최대 사다리 높이는 몇 개인가요?");
                return parseHeight(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("[입력 오류] 양의 정수를 입력해야 합니다.");
            }
        }
    }

    private static void validatePlayerInput(List<String> names) {
        if (names.isEmpty()) throw new IllegalArgumentException("한 명 이상의 참가자를 입력해야 합니다.");
    }

    private static void validateResultInput(List<String> results, int expectedSize) {
        if (results.size() != expectedSize) {
            throw new IllegalArgumentException("결과 개수는 참가자 수와 일치해야 합니다.");
        }
    }

    private static int parseHeight(String input) {
        int height = Integer.parseInt(input);
        if (height <= 0) throw new IllegalArgumentException();
        return height;
    }

    public static String readQuery() {
        System.out.println("결과를 보고 싶은 사람은? 종료를 원하면 exit를 입력하세요");
        return scanner.nextLine().trim();
    }
}
