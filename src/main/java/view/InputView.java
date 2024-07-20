package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputUsers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.");
        String users = scanner.nextLine();
        return Arrays.stream(users.split(",")).toList();
    }

    public static List<String> inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요.");
        String results = scanner.nextLine();
        return Arrays.stream(results.split(",")).toList();
    }

    public static int inputHeightCount() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
}
