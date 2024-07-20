package view;

import java.util.List;
import java.util.stream.Collectors;

import domain.Ladder;
import domain.Line;
import domain.Result;
import domain.User;

public class OutputView {

    public static void printLadder(Ladder ladder, List<User> users, List<Result> results) {
        System.out.println("\n실행 결과\n");
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

    public static void printResult(List<User> users, List<Result> results) {
        System.out.println();
        users.stream()
            .map(user -> {
                String result = results.get(user.getPosition()).getResult();
                return String.format("%s -> %s", user.getName(), result);
            })
            .forEach(System.out::println);
    }
}
