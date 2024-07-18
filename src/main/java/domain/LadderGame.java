package domain;

import java.util.List;
import java.util.stream.IntStream;

import view.InputView;
import view.OutputView;

public class LadderGame {

    private final LadderMaker ladderMaker = new LadderMaker();
    private Ladder ladder;

    public void runGame() {
        int width = InputView.printWidthCount();
        int height = InputView.printHeightCount();
        ladder = createLadder(width, height);
        List<Integer> users = makeUser(width);
        List<Integer> result = calculateResult(users);
        OutputView.printLadder(ladder);
        OutputView.printResult(users, result);
    }

    private Ladder createLadder(int width, int height) {
        return ladderMaker.createLadder(width, height);
    }

    private List<Integer> makeUser(int width) {
        return IntStream.range(0, width)
            .boxed()
            .toList();
    }

    private List<Integer> calculateResult(List<Integer> users) {
        return users.stream()
            .map(this::climbLadder)
            .toList();
    }

    private int climbLadder(int user) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            user = move(user, line);
        }
        return user;
    }

    public int move(int user, Line line) {
        List<Boolean> points = line.getPoints();
        if (points.get(user)) {
            return ++user;
        }
        if (user > 0 && points.get(user - 1)) {
            return --user;
        }
        return user;
    }

}
