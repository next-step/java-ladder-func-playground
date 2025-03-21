package controller;

import domain.Ladder;
import dto.LadderDto;
import view.InputView;

public class LadderController {
    private final Ladder ladder;
    private final InputView inputView = new InputView();

    public LadderController() {
        this.ladder = Ladder.of(inputView.getWidth(), inputView.getHeight());
    }

    public LadderDto getLadderData() {
        return LadderDto.from(ladder);
    }
}
