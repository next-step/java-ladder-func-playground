package view;

import domain.LadderHeight;
import domain.Name;
import domain.Player;
import domain.Players;
import domain.Prize;
import domain.Prizes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public Players askPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        List<Player> list = new ArrayList<>();
        for (String name : input.split(",")) {
            list.add(new Player(new Name(name.trim())));
        }
        return new Players(list);
    }

    public Prizes askPrizes() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        List<Prize> list = new ArrayList<>();
        for (String prize : input.split(",")) {
            list.add(new Prize(prize.trim()));
        }
        return new Prizes(list);
    }

    public LadderHeight askHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int input = Integer.parseInt(scanner.nextLine());
        return new LadderHeight(input);
    }

    public String askResultName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine().trim();
    }
}
