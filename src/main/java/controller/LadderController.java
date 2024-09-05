package controller;

import domain.Ladder;
import service.LadderService;
import view.OutputView;

public class LadderController {
    private final LadderService ladderService = new LadderService();
    private final OutputView outputView = new OutputView();

    public Ladder createLadder() {
        int height = 4;
        int width = 4;
        return ladderService.generateLadder(height, width);
    }

    public void printResult(Ladder ladder){
        outputView.printResult();
        outputView.printLadder(ladder);
    }
}
