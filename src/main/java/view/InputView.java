package view;

import java.util.Scanner;

public final class InputView {

    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
    }

    public static String inputPlayerNames() {
        System.out.println("참여할 플레이어의 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return sc.nextLine();
    }

    public static String inputRunningResult() {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return sc.nextLine();
    }

    public static String inputLadderHeight() {
        System.out.println();
        System.out.println("사다리의 최대 높이는 몇 인가요?");
        return sc.nextLine();
    }

    public static String inputTargetPlayerName() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return sc.nextLine();
    }
}
