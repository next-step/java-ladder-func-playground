package controller;

import generator.Generator;
import generator.RandomGenerator;
import ladder.Row;
import ladder.LadderGame;
import ladder.Column;
import people.People;
import people.Person;
import result.LadderResult;
import result.Prize;
import result.Prizes;
import strategy.LinkStrategy;
import strategy.RandomLinkStrategy;
import tuner.DefaultLadderTuner;
import tuner.LadderTuner;
import view.InputParser;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.LinkedHashMap;
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

        if (names.size() != results.size()) {
            throw new IllegalArgumentException("참여자 수와 실행 결과 수가 일치하지 않습니다.");
        }

        //3. 최대 사다리 높이 입력
        Row rows = Row.from(InputView.readLadderHeight());

        //4. 사다리 생성
        Generator generator = new RandomGenerator();
        LinkStrategy strategy = new RandomLinkStrategy(generator);

        LadderTuner tuner = new DefaultLadderTuner(strategy);
        LadderGame game = new LadderGame(rows, columns, strategy, tuner);
        //4-1. 사다리 생성 결과
        OutputView.printLadder(game.getLadder(), people, prizes);

        //5. 사다리 게임 실행
        LadderResult result = LadderResult.from(people, prizes, game);

        //5-1. 사다리 게임 결과 보기
        while (getResult(result)) {
        }
    }

    private boolean getResult(LadderResult result) {
        String resultName = InputView.readResultName().strip();

        if ("all".equalsIgnoreCase(resultName)) {
            OutputView.printAllResults(result.toNamePrizeMap());
            return false;
        }

        Prize prize = result.findByName(resultName);
        if (prize != null) {
            OutputView.printSingleResult(prize.value());
            return true;
        }

        System.out.println("존재하지 않는 이름입니다. 다시 입력해주세요.");
        return true;
    }
}
