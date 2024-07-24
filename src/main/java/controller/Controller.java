package controller;

import java.util.Random;

import model.Ladder;
import view.InputView;
import view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final Random random;

    public Controller(InputView inputView, OutputView outputView, Random random) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.random = random;
    }

    public void start() {
        outputView.outLadder(Ladder.of(4, 4, random));
    }
}
