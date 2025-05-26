package controller;

import domain.Ladder;
import domain.LadderResult;
import view.InputView;
import view.ResultView;

public class LadderController {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        int width = inputView.readWidth();
        int height = inputView.readHeight();

        Ladder ladder = Ladder.generate(width, height);
        resultView.printLadder(ladder);

        LadderResult ladderResult = new LadderResult(ladder);
        resultView.printResult(ladderResult);
    }
}
