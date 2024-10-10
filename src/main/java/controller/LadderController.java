package controller;

import domain.Ladder;
import domain.Size;
import view.OutputView;

public class LadderController {
    private final OutputView outputView = new OutputView();

    public Ladder createLadder() {
        Size height = new Size(4);
        Size width = new Size(4);
        return new Ladder(height, width);
    }

    public void printResult(Ladder ladder){
        outputView.printResult();
        outputView.printLadder(ladder);
    }
}
