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

    public String[] inputLadderGamePlayersByConsole(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Scanner(System.in).next().split(",");
    }

    public String[] inputLadderGamePrizesByConsole(){
        System.out.println("실행 결과를 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Scanner(System.in).next().split(",");
    }
}