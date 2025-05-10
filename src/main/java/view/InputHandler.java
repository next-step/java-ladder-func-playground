package view;

import domain.user.PlayerName;
import domain.user.PlayerNames;
import domain.prize.PrizeName;
import domain.prize.PrizeNames;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputHandler {

    public static final Scanner scanner = new Scanner(System.in);

    public static PlayerNames inputPlayersName() {
        while (true) {
            try {
                System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
                List<String> names = Arrays.stream(scanner.nextLine().split(","))
                        .map(String::trim)
                        .toList();
                validatePlayerInput(names);
                return new PlayerNames(names.stream()
                        .map(PlayerName::new)
                        .toList());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static PrizeNames inputPrizeNames(int expectedSize) {
        while (true) {
            try {
                System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
                List<String> values = Arrays.stream(scanner.nextLine().split(","))
                        .map(String::trim)
                        .toList();
                validatePrizeInput(values, expectedSize);
                return new PrizeNames(values.stream().map(PrizeName::new).toList());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputLadderSize() {
        while (true) {
            try {
                return getValidHeight();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getValidHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        int height = Integer.parseInt(scanner.nextLine());
        validateHeight(height);
        return height;
    }

    private static void validateHeight(int height) {
        if (height <= 1) {
            throw new IllegalArgumentException("사다리 높이는 2 이상이어야 합니다.\n");
        }
    }

    private static void validatePlayerInput(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("두 명 이상의 참가자를 입력해야 합니다.\n");
        }

        long uniqueCount = names.stream().distinct().count();
        if (uniqueCount != names.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.\n");
        }
    }

    private static void validatePrizeInput(List<String> prizes, int expectedSize) {
        if (prizes.size() != expectedSize) {
            throw new IllegalArgumentException("결과 개수는 참가자 수와 일치해야 합니다.");
        }
    }

    public static String inputPlayerResult() {
        System.out.println("\n결과를 보고 싶은 사람은? 종료를 원하면 exit를 입력하세요");
        return scanner.nextLine().trim();
    }
}
