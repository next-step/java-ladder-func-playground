package view;

import java.util.List;
import java.util.stream.Collectors;

import domain.Ladder;
import domain.Line;

public class OutputView {

    public static void printLadder(Ladder ladder) {
        System.out.println("실행 결과\n");
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
}
