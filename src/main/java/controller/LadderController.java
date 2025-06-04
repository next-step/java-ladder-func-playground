package controller;

import generator.Generator;
import generator.RandomGenerator;
import ladder.Height;
import ladder.LadderGame;
import ladder.Width;
import strategy.LinkStrategy;
import strategy.RandomLinkStrategy;
import tuner.DefaultLadderTuner;
import tuner.LadderTuner;
import view.InputView;
import view.OutputView;

public class LadderController {
    public void run() {
        Width width = Width.from(InputView.readLadderWidth());
        Height height = Height.from(InputView.readLadderHeight());

        Generator generator = new RandomGenerator();
        LinkStrategy strategy = new RandomLinkStrategy(generator);

        LadderTuner tuner = new DefaultLadderTuner(strategy);
        LadderGame game = new LadderGame(height, width, strategy, tuner);

        OutputView.printLadder(game.getLadder());
    }
}
