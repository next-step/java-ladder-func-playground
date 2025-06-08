package controller;

import domain.Ladder;
import domain.LadderGame;
import domain.Line;
import view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import view.OutputView;

public class LadderController {

    private Random rd = new Random();

    public void run() {
        // 입력 받기
        List<String> names = InputView.getNames();
        List<String> results = InputView.getResults();
        int height = InputView.getHeight();
        int width = names.size();

        // 사다리 생성
        Ladder ladder = createLadder(width, height);

        // 게임 객체 생성
        LadderGame game = new LadderGame(names, results, ladder);

        // 사다리 출력
        OutputView.printLadderGame(game, ladder);

        // 결과 조회
        String targetName = InputView.getTargetName();

        if (targetName.equals("all")) {
            OutputView.printAllResults(game.getAllResults());
        } else {
            String result = game.getResultForPerson(targetName);
            OutputView.printPersonResult(result);
        }
    }

    private Ladder createLadder(int width, int height) {
        Ladder ladder = new Ladder();

        for (int i = 0; i < height; i++) {
            List<Boolean> points = addPointsBoolean(width);
            Line line = new Line(points);
            ladder.add(line);
        }
        return ladder;
    }

    private List<Boolean> addPointsBoolean(int width) {
        List<Boolean> booleanList = new ArrayList<>();
        boolean prevConnected = false;

        for (int i = 1; i < width; i++) {
            boolean current = getNextConnection(prevConnected);
            booleanList.add(current);
            prevConnected = current;
        }
        return booleanList;
    }

    private boolean getNextConnection(boolean prevConnected) {
        if (prevConnected) {
            return false;
        }
        return rd.nextBoolean();
    }
}
