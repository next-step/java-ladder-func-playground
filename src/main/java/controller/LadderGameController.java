package controller;

import constant.ErrorMessage;
import domain.Ladder;
import domain.LadderResult;
import domain.Player;
import domain.Players;
import domain.Prizes;
import domain.strategy.BooleanGenerator;
import dto.LadderResponse;
import dto.LadderResultResponse;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class LadderGameController {
    private final static String ALL_PRINT_CONDITION = "all";

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

        processResults(ladder, players, prizes);
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

    private void processResults(Ladder ladder, Players players, Prizes prizes) {
        displayLadder(ladder, players, prizes);

        LadderResult ladderResult =new LadderResult(players, prizes, ladder.getAllResult());
        queryResults(ladderResult, players);
    }

    private void displayLadder(Ladder ladder, Players players, Prizes prizes) {
        LadderResponse ladderResponse = LadderResponse.from(ladder);
        outputView.printGameBoard(ladderResponse, players.getPlayersName(), prizes.getPrizeNames());
    }

    private void queryResults(LadderResult ladderResult, Players players) {
        boolean isRunning = true;
        while (isRunning) {
            String target = repeatUntilSuccess(() -> readCommand(players));

            isRunning = processCommand(ladderResult, target);
        }
    }

    private String readCommand(Players players) {
        outputView.printTargetNameGuide();
        String input = inputView.readInput();

        if (input.equals(ALL_PRINT_CONDITION)) {
            return input;
        }

        if (!players.containsPlayer(new Player(input))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_NAME.getMessage());
        }

        return input;
    }

    private boolean processCommand(LadderResult ladderResult, String target) {
        if (target.equals(ALL_PRINT_CONDITION)) {
            LadderResultResponse ladderResultResponse = LadderResultResponse.from(ladderResult);
            outputView.printTotalTargetResult(ladderResultResponse);
            return false;
        }

        outputView.printTargetResult(ladderResult.getResultByPlayer(new Player(target)));
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
