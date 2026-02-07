package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Point;

public class OutputView {

    private static final String VERTICAL_BAR = "|";
    private static final String BRIDGE = "-----";
    private static final String EMPTY = "     ";

    public static void printLadder(Ladder ladder) {
        System.out.println("\n실행 결과\n");
        ladder.getLines().forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        System.out.print(VERTICAL_BAR);
        line.getPoints().forEach(OutputView::printPoint);
        System.out.println();
    }

    private static void printPoint(Point point) {
        if (point.hasBridge()) {
            System.out.print(BRIDGE + VERTICAL_BAR);
            return;
        }
        System.out.print(EMPTY + VERTICAL_BAR);
    }

}
