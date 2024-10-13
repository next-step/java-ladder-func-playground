package controller;

import domain.Ladder;
import domain.Size;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public Ladder createLadder() {
        Size width = inputView.getLadderWidth();
        Size height = inputView.getLadderHeight();
        return new Ladder(height, width);
    }

    public void printResult(Ladder ladder){
        outputView.printResult();
        outputView.printLadder(ladder);
    }
}
