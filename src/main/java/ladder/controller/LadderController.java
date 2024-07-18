package ladder.controller;

import java.util.List;
import java.util.Map;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.RandomLadderGenerator;
import ladder.domain.Result;
import ladder.domain.ResultMap;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {

    public void play() {
        List<String> names = InputView.getNames();
        List<String> results = InputView.getResult();
        int height = InputView.getHeight();

        Ladder ladder = new Ladder(new RandomLadderGenerator(names.size(), height));
        OutputView.printLadder(ladder.getLadder(), names, results);

        LadderGame ladderGame = new LadderGame(ladder, names.size());
        ladderGame.move();

        String resultTarget = InputView.wantResult();
        Result result = new Result(new ResultMap(names, results, ladderGame.getResult()), resultTarget);

        if (result.getResult() instanceof Map) {
            OutputView.printResult((Map<String, String>)result.getResult());
        }
        if (result.getResult() instanceof String) {
            OutputView.printResult((String)result.getResult());
        }
    }
}
