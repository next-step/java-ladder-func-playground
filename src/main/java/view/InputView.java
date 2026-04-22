package view;

import java.util.Scanner;

public class InputView {
    Scanner scanner=new Scanner(System.in);

    public String readNames(){
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public String readTargets(){
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    public int readHeight(){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input=scanner.nextLine();

        return Integer.parseInt(input.trim());
    }

    public String readTargetResult(){
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

}
