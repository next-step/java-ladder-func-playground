package view;

import java.util.List;
import java.util.stream.Collectors;

import domain.Ladder;
import domain.Line;
import domain.Result;
import domain.User;

public class OutputView {

    public static void printLadder(Ladder ladder, List<User> users, List<Result> results) {
        System.out.println("\n사다리 결과\n");
        List<Line> lines = ladder.getLines();

        users.forEach(user -> System.out.print(user.getName() + " "));
        System.out.println();
        lines.forEach(line -> System.out.println(drawLine(line.getPoints())));
        results.forEach(result -> System.out.print(" " + result.getResult() + " "));
    }

    private static String drawLine(List<Boolean> points) {
        return points.stream()
            .map(point -> {
                if (point) {
                    return "|----";
                }
                return "|    ";
            })
            .collect(Collectors.joining());
    }

    public static void printResult(String userName, List<User> users, List<Result> results) {
        if (userName.equals("all")) {
            printAllResult(users, results);
            return;
        }
        User wantedUser = users.stream()
            .filter(user -> user.getName().equals(userName))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("잘못된 이름입니다."));
        printUserResult(wantedUser, results);
    }

    private static void printUserResult(User user, List<Result> results) {
        System.out.println(results.get(user.getPosition()).getResult());
    }

    private static void printAllResult(List<User> users, List<Result> results) {
        users.stream()
            .map(user -> {
                String result = results.get(user.getPosition()).getResult();
                return String.format("%s : %s", user.getName(), result);
            })
            .forEach(System.out::println);
    }
}
