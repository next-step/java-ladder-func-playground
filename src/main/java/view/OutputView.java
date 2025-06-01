package view;

import domain.Line;
import domain.Point;
import domain.ladder.Ladder;
import java.util.List;

public final class OutputView {

    private static final String LADDER_RESULT_TITLE = "실행결과";
    private static final String BLANK = "     ";
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-----";

    private OutputView() {
    }

    public static void printLadderResultTitle() {
        System.out.println();
        System.out.println(LADDER_RESULT_TITLE);
        System.out.println();
    }

    public static void drawLadder(final Ladder ladder) {
        for (Line line : ladder.getLines()) {
            drawLine(line);
        }
    }

    private static void drawLine(final Line line) {
        StringBuilder builder = new StringBuilder();
        builder.append(BLANK);

        List<Point> points = line.getPoints();
        for (int i = 0; i < points.size() - 1; i++) {
            builder.append(VERTICAL);
            builder.append(drawHorizontalIfConnected(points.get(i)));
        }
        builder.append(VERTICAL);
        System.out.println(builder);
    }

    private static String drawHorizontalIfConnected(final Point point) {
        if (point.right()) {
            return HORIZONTAL;
        }
        return BLANK;
    }
}
