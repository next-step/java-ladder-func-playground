package view;

import domain.PlayerName;
import domain.Players;
import domain.Reward;
import domain.Rewards;

import java.util.Scanner;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public Players readPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return new Players(parseNames(SCANNER.nextLine()));
    }

    private List<PlayerName> parseNames(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(PlayerName::new)
                .collect(Collectors.toList());
    }

    public Rewards readRewards() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return new Rewards(parseRewards(SCANNER.nextLine()));
    }

    private List<Reward> parseRewards(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Reward::new)
                .collect(Collectors.toList());
    }

    public int readHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public String readTargetPerson() {
        System.out.println("\n결과를 보고 싶은 사람은?");
        return SCANNER.nextLine().trim();
    }
}