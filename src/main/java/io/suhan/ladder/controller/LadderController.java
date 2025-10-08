package io.suhan.ladder.controller;

import io.suhan.ladder.model.Ladder;
import io.suhan.ladder.model.LadderFactory;
import io.suhan.ladder.model.LadderGame;
import io.suhan.ladder.view.InputView;
import io.suhan.ladder.view.OutputView;

public class LadderController {
    public void run() {
        int width = InputView.getLadderWidth();
        int height = InputView.getLadderHeight();

        Ladder ladder = LadderFactory.createLadder(width, height);

        LadderGame game = new LadderGame(ladder);

        game.execute();
    }
}
