package view;

import domain.LadderHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public List<String> readPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요): ");

        String userInput = scanner.nextLine();
        return Arrays.stream(userInput.split(","))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());
    }

    public List<String> readResultItems() {
        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요): ");

        String userInput = scanner.nextLine();
        return new ArrayList<>(Arrays.asList(userInput.split(",")));
    }

    public LadderHeight readHeight() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = scanner.nextInt();
        scanner.nextLine();
        return new LadderHeight(height);
    }

    public String readResultRequest() {
        System.out.println();
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine().trim();
    }
}
