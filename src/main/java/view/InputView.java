package view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public String readNames() {
        printMessage("참여할 사람 이름을 입력하세요. (이름으로 all은 안됩니다. 이름은 쉼표(,)로 구분하세요)");
        return readValidLine();
    }

    public String readResults() {
        printMessage("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return readValidLine();
    }

    public int readHeight() {
        printMessage("\n최대 사다리 높이는 몇 개인가요?");
        return readValidPositiveInteger();
    }

    public String readNameForResult() {
        printMessage("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine().trim();
    }

    private String readValidLine() {
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            printMessage("값을 입력해주세요. 빈 값은 허용되지 않습니다.");
            return readValidLine();
        }
        return input;
    }

    private int readValidPositiveInteger() {
        String input = scanner.nextLine().trim();
        if (!isPositiveNumber(input)) {
            printMessage("1 이상의 숫자를 입력해주세요.");
            return readValidPositiveInteger();
        }
        return Integer.parseInt(input);
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
