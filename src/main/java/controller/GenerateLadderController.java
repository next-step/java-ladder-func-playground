package controller;

import constants.ScriptConstants;
import model.Ladder;
import model.LadderBuilder;
import view.InputView;
import view.OutputView;

public class GenerateLadderController {
    private final LadderBuilder ladderBuilder;
    private final InputView inputView;
    public GenerateLadderController(LadderBuilder ladderBuilder, InputView inputView) {
        this.ladderBuilder = ladderBuilder;
        this.inputView = inputView;
    }

    public Ladder generateLadder() {
        int height = inputView.getSingleIntegerFromUserAfterShowingAScript(ScriptConstants.INPUT_HEIGHT_SCRIPT);
        int width = inputView.getSingleIntegerFromUserAfterShowingAScript(ScriptConstants.INPUT_WIDTH_SCRIPT);
        return ladderBuilder.generateLadder(height,width);
    }
}
