package controller;

import java.util.*;
import model.*;
import view.*;

public class LadderGameController {
    private final List<Player> players;
    private final List<String> results;
    private final Ladder ladder;
    private LadderResult ladderResult;

    public LadderGameController(List<String> names, List<String> results, int height) {
        this.players = createPlayers(names);
        this.results = results;
        this.ladder = new Ladder(players.size(), height);
    }

    private List<Player> createPlayers(List<String> names) {
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }
        return players;
    }

    public void play() {
        // 1. 사다리 출력
        OutputView.printLadder(players, ladder.getLines(), results);

        // 2. 사다리 결과 생성
        this.ladderResult = ladder.run(players, results);

        // 3. 결과 조회
        showResults();
    }

    private void showResults() {
        while (true) {
            String query = InputView.getQuery();

            if (query.equals("all")) {
                OutputView.printAllResults(ladderResult.getAllResults());
                break;  // 전체 결과 출력 후 종료
            }

            if (ladderResult.getAllResults().containsKey(query)) {
                OutputView.printResult(query, ladderResult.getResult(query));
            } else {
                System.out.println("존재하지 않는 이름입니다. 다시 입력해주세요.");
            }
        }
    }
}
