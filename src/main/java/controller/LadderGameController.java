package controller;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import model.*;
import util.Parser;
import view.InputView;
import view.LadderView;
import view.LineView;
import view.OutputView;

public class LadderGameController {

    private final LadderGenerator ladderGenerator;
    private final OutputView outputView;
    private final InputView inputView;

    private static final String VIEW_ALL = "all";

    public LadderGameController(
        LadderGenerator ladderGenerator,
        OutputView outputView,
        InputView inputView
    ) {
        this.ladderGenerator = new LadderGenerator(new Random());
        this.outputView = new OutputView(new LadderView(new LineView()));
        this.inputView = new InputView(new Scanner(System.in));
    }

    public void run() {
        Players players = inputPlayers();
        Prizes prizes = inputPrizes();

        Width width = new Width(players.size());
        Height height = new Height(inputView.inputHeight());
        Ladder ladder = ladderGenerator.generate(height, width);

        outputView.printExecuteResult(ladder, players, prizes);

        printResultByViewerName(ladder, players, prizes);
    }

    private Players inputPlayers() {
        String strPlayerNames = inputView.inputPlayerNames();
        List<String> playerNames = Parser.parseStringToList(strPlayerNames);

        return new Players(playerNames);
    }

    private Prizes inputPrizes() {
        String strPrizeNames = inputView.inputPrizeNames();
        List<String> prizeNames = Parser.parseStringToList(strPrizeNames);

        return new Prizes(prizeNames);
    }

    private void printResultByViewerName(Ladder ladder, Players players, Prizes prizes) {
        String resultViewerName = inputView.inputResultViewerName();

        if (resultViewerName.equalsIgnoreCase(VIEW_ALL)) {
            outputView.printAllPlayerResult(ladder, players, prizes);
        } else {
            outputView.printSinglePlayerResult(ladder, players, prizes, resultViewerName);
        }
    }
}
