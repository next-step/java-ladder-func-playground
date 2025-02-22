package controller;

import dto.response.GetLadderResultResponse;
import dto.response.GetLadderShapeResponse;
import service.LadderService;
import view.LadderInputView;
import view.LadderOutputView;

public class LadderController {

    private final LadderService ladderService;
    private final LadderInputView ladderInputView;
    private final LadderOutputView ladderOutputView;

    public LadderController(LadderService ladderService, LadderInputView ladderInputView, LadderOutputView ladderOutputView) {
        this.ladderService = ladderService;
        this.ladderInputView = ladderInputView;
        this.ladderOutputView = ladderOutputView;
    }

    public void play() {
        int width = ladderInputView.inputLadderWidth();
        int height = ladderInputView.inputLadderHeight();
        ladderService.createLadder(height, width);
        GetLadderShapeResponse getLadderShapeResponse = ladderService.getLadderShape();
        ladderOutputView.printLadder(getLadderShapeResponse.ladders());
        GetLadderResultResponse getLadderResultResponse = ladderService.getLadderAllResult();
        ladderOutputView.printLadderResult(getLadderResultResponse.result());
    }
}
