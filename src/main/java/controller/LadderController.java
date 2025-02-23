package controller;

import domain.Ladder;
import view.InputView;
import view.ResultView;

public class LadderController {

    public void run() {
        int width = InputView.inputWidth();
        int height = InputView.inputHeight();
        Ladder ladder = Ladder.createLadder(width, height);
        ResultView.print(ladder);
    }
}
