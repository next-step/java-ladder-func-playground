package view;

import java.util.Scanner;

public class InputView {

    public int inputLadderWidthByConsole(){
        System.out.println("사다리의 넓이는 몇 개인가요?");
        return new Scanner(System.in).nextInt();
    }

    public int inputLadderHeightByConsole(){
        System.out.println("사다리의 높이는 몇 개인가요?");
        return new Scanner(System.in).nextInt();
    }
}