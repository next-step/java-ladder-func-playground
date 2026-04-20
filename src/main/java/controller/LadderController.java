package controller;

import domain.LadderResult;
import domain.Ladder;
import domain.LadderGame;
import domain.Players;
import dto.PrizeResult;
import generator.ConnectionGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

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
        Players players = Players.of(inputView.readPlayerNames());
        LadderResult ladderResult = new LadderResult(inputView.readPlayResult());
        Ladder ladder = Ladder.of(players.size(), inputView.readHeight(), connectionGenerator);
        LadderGame ladderGame = new LadderGame(ladder);
        outputView.printLadder(ladder.toBooleanLists(), players.getPlayerNames(), ladderResult.getPrizes());
        List<PrizeResult> prizeResults = PrizeResult.from(ladderResult.matchPrize(ladderGame.play(players)));
        printResult(prizeResults);
    }

    private void printResult(List<PrizeResult> prizeResults) {
        String input = inputView.readWantResult();

        while (!input.equals("all")) {
            PrizeResult result = findByName(prizeResults, input);
            System.out.println("실행결과");
            System.out.println(result.prize());
            System.out.println();

            input = inputView.readWantResult();
        }

        outputView.printAllResult(prizeResults);
    }

    private PrizeResult findByName(List<PrizeResult> prizeResults, String name) {
        return prizeResults.stream()
                .filter(result -> result.playerName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름의 결과가 없습니다."));
    }
}
