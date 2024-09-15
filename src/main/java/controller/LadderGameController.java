package controller;

import domain.Ladders;
import domain.RungsBuilder;
import service.LaddersService;
import view.OutputView;

public class LadderGameController {

    private final LaddersService laddersService;
    private final OutputView outputView;

    public LadderGameController(RungsBuilder rungsBuilder) {
        this.laddersService = new LaddersService(rungsBuilder);
        this.outputView = new OutputView();
    }

    public void start() {
        int countOfLadders = 3;
        int height = laddersService.getHeight();

        Ladders ladders = laddersService.createLadder(countOfLadders, height);
        outputView.printStatusOfLadders(ladders.getAllRungsPositionAtLadder(), height);
    }

}
