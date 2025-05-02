package view;

import utils.InputParser;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputLadderWidth() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String playersString = scanner.nextLine();
        return InputParser.parseByComma(playersString);
    }

    public int inputLadderHeight() {
        System.out.println("사다리의 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        scanner.nextLine();
        return height;
    }

    public List<String> inputPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String resultNamesString = scanner.nextLine();
        return InputParser.parseByComma(resultNamesString);
    }

    public String inputTargetPlayerName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
