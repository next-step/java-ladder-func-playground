package controller;

import domain.Ladder;
import domain.LadderResult;
import domain.Player;
import domain.Players;
import domain.Rewards;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import view.InputView;
import view.LadderDisplayDto;
import view.PlayerResultDto;
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
        Ladder ladder = setUpLadder(players);

        displayLadder(players, ladder, rewards);

        LadderResult ladderResult = new LadderResult(ladder, players, rewards);
        String targetName = inputView.readTargetName();
        displayResult(targetName, ladderResult);
    }

    private Players setUpPlayers() {
        List<String> names = inputView.readNames();
        List<Player> players = names.stream()
                .map(Player::new)
                .toList();
        return new Players(players);
    }

    private Rewards setUpResults() {
        List<String> results = inputView.readRewards();
        return new Rewards(results);
    }

    private Ladder setUpLadder(Players players) {
        int width = players.getCount();
        int height = inputView.readHeight();
        return Ladder.generate(width, height);
    }

    private void displayLadder(Players players, Ladder ladder, Rewards rewards) {
        List<String> playerNames = players.getPlayerNames();
        List<List<Boolean>> lines = ladder.getLinePoints();
        List<String> rewardNames = rewards.getRewards();

        LadderDisplayDto ladderDisplayDto = new LadderDisplayDto(playerNames, lines, rewardNames);
        resultView.printLadder(ladderDisplayDto);
    }

    private void displayResult(String target, LadderResult ladderResult) {
        if (target.equals("all")) {
            displayAllResults(ladderResult);
            return;
        }
        displaySingleResult(ladderResult, target);
    }

    private void displayAllResults(LadderResult ladderResult) {
        Map<String, String> results = ladderResult.getResults();
        List<PlayerResultDto> resultsDto = results.entrySet().stream()
                .map(entry -> new PlayerResultDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        resultView.printAllResults(resultsDto);
    }

    private void displaySingleResult(LadderResult ladderResult, String target) {
        String result = ladderResult.getResult(target);
        PlayerResultDto resultDto = new PlayerResultDto(target, result);
        resultView.printSingleResult(resultDto);
    }
}
