package controller;

import generator.Generator;
import generator.RandomGenerator;
import ladder.Row;
import ladder.LadderGame;
import ladder.Column;
import people.People;
import result.LadderResult;
import result.Prizes;
import strategy.LinkStrategy;
import strategy.RandomLinkStrategy;
import tuner.DefaultLadderTuner;
import tuner.LadderTuner;
import view.InputParser;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderController {
    public void run() {
        //1. 참여할 사람 이름을 입력
        List<String> names = InputParser.parseCommaSeparated(InputView.readName());
        People people = People.from(names);

        Column columns = Column.from(people.size());

        //2. 실행 결과 입력
        List<String> results = InputParser.parseCommaSeparated(InputView.readPrize());
        Prizes prizes = Prizes.from(results);

        //3. 최대 사다리 높이 입력
        Row rows = Row.from(InputView.readLadderHeight());

        //4. 사다리 생성
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
