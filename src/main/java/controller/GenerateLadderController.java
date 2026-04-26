package controller;

import model.Ladder;
import model.LadderBuilder;
import view.OutputView;

public class GenerateLadderController {
    private final LadderBuilder ladderBuilder;
    public GenerateLadderController(LadderBuilder ladderBuilder) {
        this.ladderBuilder = ladderBuilder;
    }

    public Ladder generateLadder() {
        return ladderBuilder.generateLadder(4,4);
    }
}
