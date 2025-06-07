package controller;

import generator.Generator;
import generator.RandomGenerator;
import ladder.Height;
import ladder.LadderGame;
import ladder.Width;
import result.LadderResult;
import strategy.LinkStrategy;
import strategy.RandomLinkStrategy;
import tuner.DefaultLadderTuner;
import tuner.LadderTuner;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.Map;

public class LadderController {
    public void run() {
        Width width = Width.from(InputView.readLadderWidth());
        Height height = Height.from(InputView.readLadderHeight());

        Generator generator = new RandomGenerator();
        LinkStrategy strategy = new RandomLinkStrategy(generator);

        LadderTuner tuner = new DefaultLadderTuner(strategy);
        LadderGame game = new LadderGame(height, width, strategy, tuner);

        OutputView.printLadder(game.getLadder());

        //사다리 게임 결과 출력
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < width.width(); i++) {
            resultMap.put(i, game.play(i));
        }
        LadderResult result = new LadderResult(resultMap);
        OutputView.printResult(result);
    }
}
