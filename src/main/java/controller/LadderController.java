package controller;

import domain.Ladder;
import domain.LadderResult;
import domain.Player;
import domain.Players;
import domain.Rewards;
import java.util.List;
import view.InputView;
import view.ResultView;

public class LadderController {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Players players = setUpPlayers();
        Rewards rewards = setUpResults();

        Ladder ladder = setUpLadder(players.getCount());
        resultView.printLadder(ladder, players, rewards);

        LadderResult ladderResult = new LadderResult(ladder, players, rewards);
        String targetName = inputView.readTargetName();
        resultView.printResult(ladderResult, targetName);
    }

    private Players setUpPlayers() {
        List<String> names = inputView.readNames();
        List<Player> players = names.stream()
                .map(Player::new)
                .toList();
        return new Players(players);
    }

    private Rewards setUpResults() {
        List<String> results = inputView.readResults();
        return new Rewards(results);
    }

    private Ladder setUpLadder(int width) {
        int height = inputView.readHeight();
        return Ladder.generate(width, height);
    }
}
