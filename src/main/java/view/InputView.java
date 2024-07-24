package view;

import java.util.Scanner;

public class InputView {
    public int getWidth() {
        System.out.println("사다리의 넓이는 몇 개인가요?");
        int width = getInt();
        System.out.println();
        return width;
    }

    public int getHeight() {
        System.out.println("사다리의 높이는 몇 개인가요?");
        int height = getInt();
        System.out.println();
        return height;
    }

    private int getInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
