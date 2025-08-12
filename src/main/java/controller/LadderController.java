package controller;

import java.util.*;
import model.*;
import view.*;

public class LadderController {
    private List<Player> players;
    private List<String> results;
    private Ladder ladder;
    private LadderResult ladderResult;

    public void start() {
        List<String> names = InputView.getPlayerNames();
        List<String> results = InputView.getResults();
        int height = InputView.getLadderHeight();

        this.players = createPlayers(names);
        this.results = results;
        this.ladder = new Ladder(players.size(), height);

        play();
    }

    private List<Player> createPlayers(List<String> names) {
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }
        return players;
    }

    public void play() {
        ResultView.printLadder(players, ladder.getLines(), results);

        this.ladderResult = ladder.run(players, results);

        showResults();
    }

    private void showResults() {
        while (true) {
            String query = InputView.getQuery();

            if (query.equals("all")) {
                ResultView.printAllResults(ladderResult.getAllResults());
                break;
            }

            if (ladderResult.getAllResults().containsKey(query)) {
                ResultView.printResult(query, ladderResult.getResult(query));
            }
            else {
                System.out.println("존재하지 않는 이름입니다. 다시 입력해주세요.");
            }
        }
    }
}
