package controller;

import ladder.Height;
import ladder.LadderGame;
import ladder.Width;
import strategy.RandomLinkStrategy;
import view.InputView;
import view.OutputView;

public class LadderController {
    public void run() {
        Width width = Width.from(InputView.readLadderWidth());
        Height height = Height.from(InputView.readLadderHeight());

        LadderGame game = new LadderGame(height, width, new RandomLinkStrategy());

        OutputView.printLadder(game.getLadder());
    }
}
