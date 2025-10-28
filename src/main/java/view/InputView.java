package view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public int widthSize() {
        System.out.println("사다리의 넓이는 몇 개인가요?");
        int width = scanner.nextInt();
        return width;
    }

    public int heightSize() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        return height;
    }
}
