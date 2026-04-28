package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = inputView.readPlayers();
        Rewards rewards = inputRewards(players);
        LadderHeight height = new LadderHeight(inputView.readHeight());

        Ladder ladder = Ladder.generate(new LadderWidth(players.size()), height, new RandomBooleanGenerator());
        outputView.printLadderBoard(players, ladder, rewards);

        GameResult gameResult = createGameResult(players, rewards, ladder);
        printTargetResults(gameResult);
    }

    private Rewards inputRewards(Players players) {
        Rewards rewards = inputView.readRewards();
        players.validateMatch(rewards);
        return rewards;
    }

    private GameResult createGameResult(Players players, Rewards rewards, Ladder ladder) {
        LadderResult ladderResult = ladder.play(new LadderWidth(players.size()));
        return GameResult.of(players, rewards, ladderResult);
    }

    private void printTargetResults(GameResult gameResult) {
        while (true) {
            String target = inputView.readTargetPerson();
            if (processTarget(target, gameResult)) {
                break;
            }
        }
    }

    private boolean processTarget(String target, GameResult gameResult) {
        if ("all".equals(target)) {
            outputView.printAllResults(gameResult);
            return true;
        }
        outputView.printSingleResult(gameResult.findByName(target));
        return false;
    }
}
