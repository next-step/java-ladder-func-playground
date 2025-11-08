package controller;

import domain.Ladder;
import domain.LadderResult;
import domain.LadderResultCalculator;
import domain.Players;
import domain.Prizes;
import generator.LadderGenerator;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LadderController {
    private final LadderGenerator ladderGenerator;
    private final OutputView outputView;
    private final InputView inputView;
    private final LadderResultCalculator ladderResultCalculator;

    public LadderController(
            LadderGenerator ladderGenerator,
            OutputView outputView,
            InputView inputView,
            LadderResultCalculator ladderResultCalculator
    ) {
        this.ladderGenerator = ladderGenerator;
        this.outputView = outputView;
        this.inputView = inputView;
        this.ladderResultCalculator = ladderResultCalculator;
    }

    public void run() {
        Players players = getPlayers();
        Prizes prizes = getPrizes();
        int colCount = players.size();
        int rowCount = getRow();
        Ladder ladder = ladderGenerator.generateLadder(colCount, rowCount);
        outputView.printLadder(ladder);
        LadderResult calculatedResult = new LadderResult(ladderResultCalculator.calculateResults(
                ladder,
                players.asList(),
                prizes.asList()
        ));
        checkPrizesForPlayers(calculatedResult.getMappedResult());
    }

    public Players getPlayers() {
        outputView.printPlayersInputMessage();
        String playersInput = inputView.getInputPlayers();
        return new Players(Arrays.asList(playersInput.split(",")));
    }

    public Prizes getPrizes() {
        outputView.printPrizesInputMessage();
        String prizesInput = inputView.getInputPrizes();
        return new Prizes(Arrays.asList(prizesInput.split(",")));
    }

    public void checkPrizesForPlayers(Map<String, String> calculatedResult) {
        while (true) {
            outputView.printAskPlayerMessage();
            String selectedPlayer = inputView.getInputSelectedPlayer();
            findPrizeForSelectedPlayer(selectedPlayer, calculatedResult);
        }
    }

    public void findPrizeForSelectedPlayer(String selectedPlayer, Map<String, String> calculatedResult) {
        if ("all".equals(selectedPlayer)) {
            outputView.printAllResultMessage(calculatedResult);
            return;
        }

        if (calculatedResult.containsKey(selectedPlayer)) {
            outputView.printSingleResultMessage(calculatedResult.get(selectedPlayer));
            return;
        }

        outputView.printInvalidSelectedPlayerMessage();
    }

    public int getRow() {
        outputView.printRowInput();
        return inputView.getInputRow();
    }
}
