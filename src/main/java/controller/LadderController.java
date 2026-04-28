package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final OutputView outputView;
    private final InputView inputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.outputView = outputView;
        this.inputView = inputView;

    }

    public void run() {
        LadderWidth width = new LadderWidth(inputView.readWidth());
        LadderHeight height = new LadderHeight(inputView.readHeight());
        BooleanGenerator generator = new RandomBooleanGenerator();

        Ladder ladder = Ladder.generate(width, height, generator);

        outputView.printLadder(ladder);
    }
}