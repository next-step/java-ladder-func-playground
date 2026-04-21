package controller;

import domain.Ladder;
import domain.LadderGame;
import domain.LadderResult;
import domain.Players;
import dto.PrizeResult;
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
        Players players = retryUntilValid(() -> Players.of(inputView.readPlayerNames()));
        LadderResult ladderResult = retryUntilValid(() -> new LadderResult(inputView.readPlayResult()));
        Ladder ladder = retryUntilValid(() -> Ladder.of(ladderResult.size(), inputView.readHeight(), connectionGenerator));
        LadderGame ladderGame = new LadderGame(ladder);
        outputView.printLadder(ladder.toBooleanLists(), players.getPlayerNames(), ladderResult.getPrizes());
        List<PrizeResult> prizeResults = PrizeResult.from(ladderResult.matchPrize(ladderGame.play(players)));
        printResult(prizeResults);
    }

    private void printResult(List<PrizeResult> prizeResults) {
        while (true) {
            PrizeResult result = retryUntilValid(() -> {
                String name = inputView.readWantResult();

                if (name.equals("all")) {
                    outputView.printAllResult(prizeResults);
                    return null;
                }

                return findByName(prizeResults, name);
            });

            if (result == null) {
                return;
            }

            outputView.printOneResult(result);
        }
    }

    private PrizeResult findByName(List<PrizeResult> prizeResults, String name) {
        return prizeResults.stream()
                .filter(result -> result.playerName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 플레이어는 없습니다."));
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
