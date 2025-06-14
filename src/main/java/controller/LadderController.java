package controller;

import generator.Generator;
import generator.RandomGenerator;
import ladder.Row;
import ladder.LadderGame;
import ladder.Column;
import people.People;
import result.Prizes;
import strategy.LinkStrategy;
import strategy.RandomLinkStrategy;
import tuner.DefaultLadderTuner;
import tuner.LadderTuner;
import view.InputParser;
import view.InputView;
import view.OutputView;

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

        OutputView.printLadder(game.getLadder(), people, prizes);

        //5. 사다리 실행 결과
//        Map<Integer, Integer> resultMap = new HashMap<>();
//        for (int start = 0; start < columns.value(); start++) {
//            resultMap.put(start, game.play(start));
//        }
//        LadderResult result = new LadderResult(resultMap);
//        OutputView.printResult(result);

        // 6. 결과 보기
        while (getResult(people, prizes, game)) {
        }
    }

    private boolean getResult(People people, Prizes prizes, LadderGame game){
        String resultName = InputView.readResultName().strip();

        if ("all".equalsIgnoreCase(resultName)) {
            Map<String, String> resultMap = new LinkedHashMap<>();
            for (people.Person person : people.values()) {
                int startIndex = people.indexOf(person.name());
                int endIndex = game.play(startIndex);
                String prizeValue = prizes.prizeAt(endIndex).value();
                resultMap.put(person.name(), prizeValue);
            }
            OutputView.printAllResults(resultMap);
            return false;
        }

        if (people.contains(resultName)) {
            int startIndex = people.indexOf(resultName);
            int endIndex = game.play(startIndex);
            String prizeValue = prizes.prizeAt(endIndex).value();
            OutputView.printSingleResult(prizeValue);
            return true;
        }

        System.out.println("존재하지 않는 이름입니다. 다시 입력해주세요.");
        return true;
    }
}
