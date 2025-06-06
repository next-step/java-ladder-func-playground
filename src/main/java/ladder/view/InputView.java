package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import ladder.model.Participants;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public Participants inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        return Participants.from(input);
    }

    public List<String> inputResults() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        return Arrays.asList(input.split(","));
    }

    public int inputHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public String inputGameResult() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
