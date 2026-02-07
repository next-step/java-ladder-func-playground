package ladder.view;

import java.util.Scanner;
import java.util.function.Supplier;
import ladder.domain.LadderHeight;
import ladder.domain.LadderWidth;

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

    public static LadderWidth inputWidth() {
        return input("사다리의 넓이는 몇 개인가요?", () -> {
            String input = sc.nextLine();
            return LadderWidth.from(parseToInt(input));
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
