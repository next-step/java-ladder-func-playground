package controller;

import domain.Ladder;
import domain.LadderGame;
import domain.LadderResult;
import domain.Players;
import dto.PrizeResults;
import generator.ConnectionGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class LadderController {
    private static final String ALL_RESULT_COMMAND = "all";
    private final InputView inputView;
    private final OutputView outputView;
    private final ConnectionGenerator connectionGenerator;

    public LadderController(InputView inputView, OutputView outputView, ConnectionGenerator connectionGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.connectionGenerator = connectionGenerator;
    }

    public void run() {
        Players players = retryUntilValid(() -> Players.of(List.of(inputView.readPlayerNames())));
        LadderResult ladderResult = retryUntilValid(() -> createLadderResult(players.size()));
        Ladder ladder = retryUntilValid(() -> Ladder.of(ladderResult.size(), inputView.readHeight(), connectionGenerator));
        outputView.printLadder(ladder.toBooleanLists(), players.getPlayerNames(), ladderResult.getPrizes());

        LadderGame ladderGame = new LadderGame(ladder, players);
        PrizeResults prizeResults = PrizeResults.from(ladderGame.play(ladderResult.getPrizes()));
        printResult(prizeResults);
    }

    private LadderResult createLadderResult(int playerSize) {
        LadderResult ladderResult = new LadderResult(List.of(inputView.readPlayResult()));
        ladderResult.validateEnoughSize(playerSize);
        return ladderResult;
    }

    private void printResult(PrizeResults prizeResults) {
        boolean shouldContinue = true;
        while (shouldContinue) {
            shouldContinue = retryUntilValid(() -> printResultByName(prizeResults));
        }
    }

    private boolean printResultByName(PrizeResults prizeResults) {
        String name = inputView.readWantResult();

        if (name.equals(ALL_RESULT_COMMAND)) {
            outputView.printAllResult(prizeResults.toList());
            return false;
        }

        outputView.printOneResult(prizeResults.findByName(name));
        return true;
    }

    private <T> T retryUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
