package controller;

import domain.Ladder;
import generator.RandomConnectionGenerator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int width = inputView.readWidth();
        int height = inputView.readHeight();
        Ladder ladder = new Ladder(new ArrayList<>());
        ladder.createLadder(width, height, new RandomConnectionGenerator());
        outputView.printLadder(ladder.toBooleanLists());
    }
}
