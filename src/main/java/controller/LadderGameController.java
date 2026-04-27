package controller;

import domain.Ladder;
import domain.LadderResult;
import domain.Player;
import domain.Players;
import domain.Prizes;
import domain.strategy.BooleanGenerator;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class LadderGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Validator validator;
    private final BooleanGenerator booleanGenerator;

    public LadderGameController(InputView inputView, OutputView outputView, Validator validator, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.validator = validator;
        this.booleanGenerator = booleanGenerator;
    }

    public void run() {
        Players players = repeatUntilSuccess(this::readPlayers);
        Prizes prizes = repeatUntilSuccess(() -> readPrizes(players.getPlayerCount()));
        int ladderHeight = repeatUntilSuccess(this::readHeight);
        Ladder ladder = repeatUntilSuccess(() -> new Ladder(
                players.getPlayerCount(), ladderHeight, booleanGenerator
        ));

        outputView.printResult(ladder, players.getPlayersName(), prizes.getPrizeNames());
        LadderResult ladderResult = new LadderResult(players, prizes, ladder.getAllResult());
        showResult(ladderResult, players);
    }

    private Players readPlayers() {
        outputView.printPlayerNameGuide();
        return new Players(inputView.readInputSeparateByComma());
    }

    private Prizes readPrizes(int playerCount) {
        outputView.printPrizeNameGuide();
        return new Prizes(inputView.readInputSeparateByComma(), playerCount);
    }

    private int readHeight() {
        outputView.printHeightGuide();
        return validator.validateLadderSpec(inputView.readInput());
    }

    private void showResult(LadderResult ladderResult, Players players) {
        boolean isRunning = true;
        while (isRunning) {
            String target = repeatUntilSuccess(() -> readCommand(players));

            isRunning = processCommand(ladderResult, target);
        }
    }

    private String readCommand(Players players) {
        outputView.printTargetName();
        String input = inputView.readInput();

        if (input.equals("all")) {
            return input;
        }

        if (!players.containsPlayer(new Player(input))) {
            throw new IllegalArgumentException("존재하지 않는 이름입니다.");
        }

        return input;
    }

    private boolean processCommand(LadderResult ladderResult, String target) {
        if (target.equals("all")) {
            outputView.printTotalTargetResult(ladderResult.getAllResults());
            return false;
        }

        outputView.printTargetResult(ladderResult.getResultByPlayerName(new Player(target)));
        return true;
    }

    private <T> T repeatUntilSuccess(Supplier<T> callBack) {
        while (true) {
            try {
                return callBack.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
