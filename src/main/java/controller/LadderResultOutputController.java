package controller;

import model.Ladder;
import view.OutputView;

public class LadderResultOutputController {
    private final Ladder ladder;
    private final OutputView outputView;

    public LadderResultOutputController(Ladder ladder, OutputView outputView) {
        this.ladder = ladder;
        this.outputView = outputView;
    }

    public void printLadderResults() {
        printLadder();
        printAllLadderPair();
    }

    private void printLadder() {
        outputView.printSingleString(ladder.toString());
    }

    private void printAllLadderPair() {
        outputView.printLineBreak();
        for (int i = 0 ; i < ladder.calculateWidth(); i++) {
            outputView.printSingleString(ladder.calculateSingleResultAsDto(i).toString());
        }
    }
}
