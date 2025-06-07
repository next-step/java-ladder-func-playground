package controller;

import generator.Generator;
import generator.RandomGenerator;
import ladder.Row;
import ladder.LadderGame;
import ladder.Column;
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
        Column columns = Column.from(InputView.readLadderWidth());
        Row rows = Row.from(InputView.readLadderHeight());

        Generator generator = new RandomGenerator();
        LinkStrategy strategy = new RandomLinkStrategy(generator);

        LadderTuner tuner = new DefaultLadderTuner(strategy);
        LadderGame game = new LadderGame(rows, columns, strategy, tuner);

        OutputView.printLadder(game.getLadder());

        //사다리 게임 결과 출력
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int start = 0; start < columns.value(); start++) {
            resultMap.put(start, game.play(start));
        }
        LadderResult result = new LadderResult(resultMap);
        OutputView.printResult(result);
    }
}
