package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {

    private final BooleanGenerator booleanGenerator;
    private final InputView inputView;
    private final OutputView outputView;
    private LadderGame ladderGame;

    public Controller(BooleanGenerator booleanGenerator, InputView inputView, OutputView outputView) {
        this.booleanGenerator = booleanGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = Players.from(inputPlayers());
        Prizes prizes = Prizes.from(inputPrizes());
        LadderHeight ladderHeight = new LadderHeight(inputLadderHeight());
        Ladder ladder = Ladder.create(booleanGenerator, ladderHeight, players);

        ladderGame = LadderGame.create(ladder, players, prizes);
        printLadderGameBoard(ladder, players, prizes);

        LadderResult ladderResult = ladderGame.play();
        outputResult(ladderResult);
    }

    private void outputResult(LadderResult ladderResult) {
        String targetName = inputView.inputTargetPlayerName();
        while (!targetName.equals("all")) {
            outputView.outputResultByName(ladderResult.prizeOf(targetName));
            targetName = inputView.inputTargetPlayerName();
        }
        outputView.outputAllResult(ladderResult.all());
    }

    private void printLadderGameBoard(Ladder ladder, Players players, Prizes prizes) {
        outputLadderHeader();
        outputPlayers(players);
        outputLadder(ladder);
        outputResultNames(prizes);
    }

    private void outputLadderHeader() {
        outputView.outputLadderHeader();
    }

    private String inputTargetPlayerName() {
        return inputView.inputTargetPlayerName();
    }

    private List<String> inputPlayers() {
        return inputView.inputLadderWidth();
    }

    private List<String> inputPrizes() {
        return inputView.inputPrizes();
    }

    private int inputLadderHeight() {
        return inputView.inputLadderHeight();
    }

    private void outputPlayers(Players players) {
        outputView.outputPlayers(players);
    }

    private void outputLadder(Ladder ladder) {
        outputView.outputLadder(ladder);
    }

    private void outputResultNames(Prizes prizes) {
        outputView.outputResultNames(prizes);
    }
}
