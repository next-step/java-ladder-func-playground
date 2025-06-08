package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    //사다리 높이 입력 받기
    public static int getHeight() {
        System.out.println("사다리의 높이는 몇 개인가요?");
        return sc.nextInt();
    }

    // 참여자 이름들 입력받기
    public static List<String> getNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = sc.nextLine();
        if (input.isEmpty()) {
            input = sc.nextLine(); // nextInt() 후 남은 개행문자 처리
        }
        return Arrays.asList(input.split(","));
    }

    // 실행 결과들 입력받기
    public static List<String> getResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = sc.nextLine();
        return Arrays.asList(input.split(","));
    }

    // 결과를 보고 싶은 사람 입력받기
    public static String getTargetName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return sc.nextLine();
    }
}
