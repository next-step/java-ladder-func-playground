package view;

import java.util.Scanner;

public class LadderInputView {

    private static final String INPUT_SEPARATOR = ",";

    private static final LadderInputView ladderInputView = new LadderInputView();

    private final Scanner scanner = new Scanner(System.in);

    private LadderInputView() {
    }

    public static LadderInputView getInstance() {
        return ladderInputView;
    }

    public String[] getNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();

        System.out.println();

        return names.split(INPUT_SEPARATOR);
    }

    public String[] getResultValues() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String resultValues = scanner.nextLine();

        System.out.println();

        return resultValues.split(INPUT_SEPARATOR);
    }

    public int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = Integer.parseInt(scanner.nextLine());

        System.out.println();

        return height;
    }

    public String getTargetName() {
        System.out.println("결과를 보고 싶은 사람은?");
        String targetName = scanner.nextLine();

        System.out.println();

        return targetName;
    }

}
