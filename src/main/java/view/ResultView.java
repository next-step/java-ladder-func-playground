package view;

import domain.Ladder;
import domain.Line;

public class ResultView {
    private static final String VERTICAL_LINE = "|";
    private static final String CONNECTED_SEGMENT = "-----";
    private static final String EMPTY_SEGMENT = "     ";

    public void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        for (boolean point : line.getPoints()) {
            sb.append(VERTICAL_LINE);
            sb.append(drawPoint(point));
        }
        sb.append(VERTICAL_LINE);
        System.out.println(sb);
    }

    private String drawPoint(boolean point) {
        if (point) return CONNECTED_SEGMENT;
        return EMPTY_SEGMENT;
    }
}
