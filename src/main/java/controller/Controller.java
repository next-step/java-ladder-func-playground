package controller;

import model.Ladder;
import view.InputView;
import view.LadderResponse;
import view.OutputView;

public class Controller {
    private static final int DEFAULT_HEIGHT_OF_LADDER = 4;
    private static final int DEFAULT_WEIGHT_OF_LADDER = 4;

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Ladder ladder = Ladder.of(
                DEFAULT_HEIGHT_OF_LADDER,
                DEFAULT_WEIGHT_OF_LADDER
        );

        outputView.printLadder(LadderResponse.from(ladder));
    }
}

