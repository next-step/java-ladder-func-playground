package view;

import domain.Ladder;
import domain.Line;
import domain.Point;

import java.util.Map;

public class LadderView {
    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        StringBuilder builder = new StringBuilder();
        for (Point point : line.getPoints()) {
            builder.append("|");
            builder.append(point.isConnected() ? "-----" : "     ");
        }
        builder.append("|");
        System.out.println(builder);
    }

    public static void printResults(Map<Integer, Integer> results) {
        System.out.println();
        for (Map.Entry<Integer, Integer> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
