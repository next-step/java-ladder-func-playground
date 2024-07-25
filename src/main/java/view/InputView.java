package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public List<String> getNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> names = getList();
        System.out.println();
        return names;
    }

    public List<String> getChoices() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
        List<String> choices = getList();
        System.out.println();
        return choices;
    }

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

    public String getName() {
        System.out.println("결과를 보고 싶은 사람은?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println();

        return name;
    }

    private int getInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private List<String> getList() {
        Scanner scanner = new Scanner(System.in);
        String list = scanner.nextLine();
        return Arrays.stream(list.split(",")).collect(Collectors.toList());
    }
}
