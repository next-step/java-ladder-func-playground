package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    //사다리 넓이 입력 받기
    public static int getWidth() {
        System.out.println("사다리의 넓이는 몇 개인가요?");
        return sc.nextInt();
    }

    //사다리 높이 입력 받기
    public static int getHeight() {
        System.out.println("사다리의 높이는 몇 개인가요?");
        return sc.nextInt();
    }
}
