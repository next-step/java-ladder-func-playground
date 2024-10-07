package controller;

import domain.CountOfLadders;
import domain.Height;
import domain.Ladders;
import domain.RungsBuilder;
import service.LaddersService;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final LaddersService laddersService;
    private final OutputView outputView;
    private final InputView inputView;

    public LadderGameController(RungsBuilder rungsBuilder) {
        this.laddersService = new LaddersService(rungsBuilder);
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void start() {
        CountOfLadders countOfLadders = getCountOfLadders();
        Height height = getHeight();

        Ladders ladders = laddersService.createLadders(countOfLadders, height);
        outputView.printStatusOfLadders(ladders.getRungsStatusAtLadder(), height.value());
    }

    private CountOfLadders getCountOfLadders() {
        outputView.printInputCountOfLaddersGuide();
        final int valueOfCountOfLadders = inputView.getUserIntegerInput();
        return new CountOfLadders(valueOfCountOfLadders);
    }

    private Height getHeight() {
        outputView.printInputHeightGuide();
        final int valueOfHeight = inputView.getUserIntegerInput();
        return new Height(valueOfHeight);
    }

}
