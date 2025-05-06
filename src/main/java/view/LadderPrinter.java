package view;

import domain.Ladder;
import domain.Line;

import java.util.List;

public class LadderPrinter {

    private static final String VERTICAL_VAR = "|";
    private static final String CONNECTION = "-----";
    private static final String EMPTY_SPACE = "     ";

    public static void outputLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        outputLines(lines);
    }

    private static void outputLines(List<Line> lines) {
        for (Line line : lines) {
            printVerticalBar();
            outputLine(line);
            System.out.println();
        }
    }

    private static void outputLine(Line line) {
        List<Boolean> points = line.getPoints();
        for (Boolean point : points) {
            printPoint(point);
            printVerticalBar();
        }
    }

    private static void printPoint(Boolean point) {
        if (point) {
            printConnection();
            return;
        }
        printEmptySpace();
    }

    private static void printVerticalBar() {
        System.out.print(VERTICAL_VAR);
    }

    private static void printConnection() {
        System.out.print(CONNECTION);
    }

    private static void printEmptySpace() {
        System.out.print(EMPTY_SPACE);
    }
}
