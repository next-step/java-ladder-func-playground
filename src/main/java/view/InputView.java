package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import model.Players;
import model.Results;

public class InputView {

    private static final Scanner SCAN = new Scanner(System.in);

    public Players readPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> players = Arrays.asList(SCAN.nextLine().split(","));
        return new Players(players);
    }

    public Results readResults(Integer playerCount) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        List<String> results = Arrays.asList(SCAN.nextLine().split(","));
        if (results.size() != playerCount) {
            throw new IllegalArgumentException("게임의 결과의 개수는 플레이어의 수와 같아야합니다.");
        }
        return new Results(results);
    }

    public Integer readLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Integer height = SCAN.nextInt();
        SCAN.nextLine();
        return height;
    }

    public String readResultPlayerName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return SCAN.nextLine();
    }

}
