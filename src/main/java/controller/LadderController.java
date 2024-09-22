package controller;

import domain.Ladder;
import view.OutputView;

public class LadderController {
    private final OutputView outputView = new OutputView();

    public Ladder createLadder() {
        int height = 4;
        int width = 4;
        return new Ladder(height, width);
    }

    public void printResult(Ladder ladder){
        outputView.printResult();
        outputView.printLadder(ladder);
    }
}
