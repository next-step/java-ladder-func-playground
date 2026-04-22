package view;

import java.util.Scanner;

public class InputView {
    Scanner scanner=new Scanner(System.in);

    public int getWidth(){
        System.out.println("사다리의 넓이는 몇 개인가요?");
        String input=scanner.nextLine();

        return Integer.parseInt(input.trim());
    }

    public int getHeight(){
        System.out.println("사다리의 높이는 몇 개인가요?");
        String input=scanner.nextLine();

        return Integer.parseInt(input.trim());
    }
}
