package controller;

import domain.Ladder;
import domain.LadderGame;
import domain.LadderResult;
import domain.Players;
import dto.PrizeResult;
import dto.PrizeResults;
import generator.ConnectionGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class LadderController {
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
        LadderResult ladderResult = retryUntilValid(() -> new LadderResult(List.of(inputView.readPlayResult())));
        Ladder ladder = retryUntilValid(() -> Ladder.of(ladderResult.size(), inputView.readHeight(), connectionGenerator));
        outputView.printLadder(ladder.toBooleanLists(), players.getPlayerNames(), ladderResult.getPrizes());

        LadderGame ladderGame = new LadderGame(ladder, players);
        PrizeResults prizeResults = PrizeResults.from(ladderGame.play(ladderResult.getPrizes()));
        printResult(prizeResults);
    }

    private void printResult(PrizeResults prizeResults) {
        while (true) {
            PrizeResult result = retryUntilValid(() -> {
                String name = inputView.readWantResult();

                if (name.equals("all")) {
                    outputView.printAllResult(prizeResults.toList());
                    return null;
                }

                return prizeResults.findByName(name);
            });

            if (result == null) {
                return;
            }

            outputView.printOneResult(result);
        }
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
