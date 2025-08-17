package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import exception.CustomException;
import exception.ErrorMessage;

public class InputView {

    private final Scanner sc;

    public InputView(Scanner sc) {
        this.sc = sc;
    }

    public int inputWidth() {
        System.out.println("사다리의 너비는 몇 개 인가요?");

        return inputValue();
    }

    public int inputHeight() {
        System.out.println("\n사다리의 높이는 몇 개 인가요?");

        return inputValue();
    }

    private int inputValue() {
        try {
            int input = sc.nextInt();
            sc.nextLine();

            return input;
        } catch (InputMismatchException ex) {
            throw new CustomException(ErrorMessage.NOT_INTEGER_FORMAT);
        }
    }

    public String inputPlayerNames() {
        System.out.println("참여할 사람의 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.");

        return sc.nextLine();
    }

    public String inputPrizeNames() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        return sc.nextLine();
    }

    public String inputResultViewerName() {
        System.out.println("\n결과를 보고 싶은 사람은?");

        return sc.nextLine();
    }
}
