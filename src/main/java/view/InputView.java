package view;

import validator.FormatValidator;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public String readNames() {
        while (true) {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String input = scanner.nextLine();
            if (FormatValidator.validateCommaSeparatedFormat(input)) {
                return input;
            }
            System.out.println("[ERROR] 올바른 형식이 아닙니다.");
        }
    }

    public String readTargets() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        while (true) {
            String input = scanner.nextLine();
            if (FormatValidator.validateCommaSeparatedFormat(input)) {
                return input;
            }
            System.out.println("[ERROR] 올바른 형식이 아닙니다.");
        }
    }

    public String readHeight() {
        while(true){
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            String input=scanner.nextLine();
            if(FormatValidator.validateIntegerFormat(input)){
                return input;
            }
            System.out.println("[ERROR] 숫자값을 입력해주세요.");
        }
    }

    public String readTargetResult() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

}
