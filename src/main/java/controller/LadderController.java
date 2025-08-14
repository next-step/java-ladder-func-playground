package controller;

import java.util.*;

import exception.ErrorMessage;
import model.*;
import view.*;

public class LadderController {

    private Players players;
    private List<String> results;
    private Ladder ladder;
    private LadderResult ladderResult;

    public void start() {
        List<String> names = InputView.getPlayerNames();
        List<String> results = InputView.getResults();
        int height = InputView.getLadderHeight();

        players = createPlayers(names);
        this.results = results;
        ladder = new Ladder(players.size(), height);

        play();
    }

    private Players createPlayers(List<String> names) {
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new Player(name));
        }
        return new Players(players);
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
                System.out.println(ErrorMessage.NOT_EXIST_NAME);
            }
        }
    }
}
