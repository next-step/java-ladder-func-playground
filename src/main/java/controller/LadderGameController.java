package controller;

import domain.CountOfLadders;
import domain.Height;
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
        CountOfLadders countOfLadders = new CountOfLadders(3);
        Height height = new Height(6);

        Ladders ladders = laddersService.createLadders(countOfLadders, height);
        outputView.printStatusOfLadders(ladders.getRungsStatusAtLadder(), height.value());
    }

}
