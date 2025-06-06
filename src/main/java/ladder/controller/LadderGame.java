package ladder.controller;

import ladder.model.Ladder;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Ladder ladder = Ladder.create();
        outputView.printLadder(ladder);
    }
}
