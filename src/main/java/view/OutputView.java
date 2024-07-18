package view;

import java.util.List;
import java.util.stream.Collectors;

import domain.Ladder;
import domain.Line;

public class OutputView {

    public static void printLadder(Ladder ladder) {
        System.out.println("\n실행 결과\n");
        List<Line> lines = ladder.getLines();
        lines.forEach(line ->
            System.out.println(drawLine(line.getPoints()))
        );
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

    public static void printResult(List<Integer> users, List<Integer> result) {
        System.out.println();
        for (int i = 0; i < users.size(); i++) {
            System.out.println(String.format("%d -> %d", users.get(i), result.get(i)));
        }
    }
}
