package view;

import domain.Ladder;
import domain.Line;
import domain.Point;

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
}
