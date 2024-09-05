package controller;

import domain.Ladders;
import service.LaddersService;
import view.OutputView;

public class LadderGameController {

    private final LaddersService laddersService;
    private final OutputView outputView;

    public LadderGameController() {
        this.laddersService = new LaddersService();
        this.outputView = new OutputView();
    }

    public void start() {
        int countOfLadders = 3;
        Ladders ladders =  laddersService.getInitialLadders(countOfLadders);
        laddersService.setRandomRungsAtLadders(ladders);
        outputView.printStatusOfLadders(ladders.getAllRungsPositionAtLadder(), ladders.getHeight());
    }
}
