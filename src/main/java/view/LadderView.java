package view;

import model.*;

public class LadderView {
    private static final String BRIDGE = "-----|";
    private static final String SPACE = "     |";
    private static final String BAR = "|";

    public static void printLadder(Ladder ladder) {
        printLines(ladder.getLines());
    }

    private static void printLines(Lines lines) {
        lines.getLines().forEach(LadderView::printLine);
    }

    private static void printLine(Line line) {
        System.out.print(BAR);
        line.getPoints().forEach(LadderView::printPoint);
        System.out.println();
    }

    private static void printPoint(Boolean point) {
        if (point) {
            System.out.print(BRIDGE);
            return;
        }
        System.out.print(SPACE);
    }
}
