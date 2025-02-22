package controller;

import dto.response.GetLadderResponse;
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
        GetLadderResponse getLadderResponse = ladderService.getLadder();
        ladderOutputView.printLadder(getLadderResponse.ladders());
    }
}
