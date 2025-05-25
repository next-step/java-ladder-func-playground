package controller;

import domain.Height;
import domain.Ladder;
import domain.LadderGame;
import domain.LadderGenerator;
import domain.Name;
import domain.Names;
import domain.Results;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Names names = inputView.readNames();
        Results results = inputView.readResults();
        Height height = inputView.readHeight();

        Ladder ladder = LadderGenerator.generate(names.size(), height);
        LadderGame ladderGame = new LadderGame(names, results, ladder);

        outputView.printLadder(names, ladder, results);

        processQuery(ladderGame);
    }

    private void processQuery(LadderGame ladderGame) {
        while (true) {
            String target = inputView.readNameForResult();
            if (isAll(target)) {
                printAllResults(ladderGame);
                return;
            }
            printSingleResult(ladderGame, target);
        }
    }

    private boolean isAll(String input) {
        return input.equals("all");
    }

    private void printAllResults(LadderGame ladderGame) {
        outputView.printAllResults(ladderGame.playAll());
    }

    private void printSingleResult(LadderGame ladderGame, String target) {
        outputView.printResult(ladderGame.play(new Name(target)));
    }
}
