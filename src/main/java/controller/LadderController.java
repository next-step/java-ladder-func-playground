package controller;

import java.util.Map;

import domain.Ladder;
import domain.LadderResult;
import view.InputView;
import view.ResultView;

public class LadderController {

    public void run() {
        int width = InputView.inputWidth();
        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(width, height);
        LadderResult ladderResult = new LadderResult(ladder);
        ResultView.outputLines(ladder);
        ResultView.outputResult(ladderResult);
    }
}
