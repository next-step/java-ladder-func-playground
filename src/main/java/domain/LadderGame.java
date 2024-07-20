package domain;

import java.util.List;

import view.InputView;
import view.OutputView;

public class LadderGame {

    private final LadderMaker ladderMaker = new LadderMaker();
    private Ladder ladder;

    public void runGame() {
        List<User> users = generateUsers(InputView.inputUsers());
        List<Result> results = generateResults(InputView.inputResults());
        int height = InputView.inputHeightCount();
        int width = users.size();

        ladder = createLadder(width, height);
        List<User> userList = calculateResult(users);
        OutputView.printLadder(ladder, users, results);
        OutputView.printResult(userList, results);
    }

    private Ladder createLadder(int width, int height) {
        return ladderMaker.createLadder(width, height);
    }

    private List<User> generateUsers(List<String> users) {
        return users.stream()
            .map(user -> new User(user, users.indexOf(user)))
            .toList();
    }

    private List<Result> generateResults(List<String> results) {
        return results.stream()
            .map(result -> new Result(result, results.indexOf(result)))
            .toList();
    }

    private List<User> calculateResult(List<User> users) {
        return users.stream()
            .map(this::climbLadder)
            .toList();
    }

    private User climbLadder(User user) {
        List<Line> lines = ladder.getLines();
        int position = user.getNumber();
        for (Line line : lines) {
            position = move(position, line);
        }
        user.setPosition(position);
        return user;
    }

    public int move(int position, Line line) {
        List<Boolean> points = line.getPoints();
        if (points.get(position)) {
            return ++position;
        }
        if (position > 0 && points.get(position - 1)) {
            return --position;
        }
        return position;
    }

}
