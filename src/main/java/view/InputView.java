package view;

import domain.Height;
import domain.Names;
import domain.Results;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public Names readNames() {
        printMessage("참여할 사람 이름을 입력하세요. (이름으로 all은 안됩니다. 이름은 쉼표(,)로 구분하세요)");
        String input = readValidLine();
        return Names.from(input);
    }

    public Results readResults() {
        printMessage("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = readValidLine();
        return Results.from(input);
    }

    public Height readHeight() {
        printMessage("\n최대 사다리 높이는 몇 개인가요?");
        int value = readValidPositiveInteger();
        return new Height(value);
    }

    public String readNameForResult() {
        printMessage("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine().trim();
    }

    private String readValidLine() {
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            return retryReadLine();
        }
        return input;
    }

    private String retryReadLine() {
        printMessage("\n값을 입력해주세요. 빈 값은 허용되지 않습니다.");
        return readValidLine();
    }

    private int readValidPositiveInteger() {
        String input = scanner.nextLine().trim();
        if (!isPositiveNumber(input)) {
            return retryReadPositiveInteger();
        }
        return Integer.parseInt(input);
    }

    private int retryReadPositiveInteger() {
        printMessage("\n1 이상의 숫자를 입력해주세요.");
        return readValidPositiveInteger();
    }

    private boolean isPositiveNumber(String input) {
        try {
            return Integer.parseInt(input) > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
