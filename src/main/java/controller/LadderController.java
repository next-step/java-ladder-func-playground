package controller;

import dto.response.GetLadderResponse;
import service.LadderService;
import view.LadderInputView;
import view.LadderOutputView;

public class LadderController {

    private final LadderService ladderService;
    private final LadderInputView inputView;
    private final LadderOutputView outputView;

    public LadderController(LadderService ladderService, LadderInputView inputView, LadderOutputView outputView) {
        this.ladderService = ladderService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        ladderService.createLadder();
        GetLadderResponse getLadderResponse = ladderService.getLadder();
        outputView.printLadder(getLadderResponse.ladders());
    }
}
