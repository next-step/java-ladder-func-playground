package view;

import domain.Ladder;
import domain.LadderResult;
import domain.Line;
import java.util.List;

public class ResultView {
    private static final String RESULT_HEADER = "실행결과";
    private static final String VERTICAL_LINE = "|";
    private static final String CONNECTED_SEGMENT = "-----";
    private static final String EMPTY_SEGMENT = "     ";
    private static final String RESULT_FORMAT = "%d -> %d%n";

    public void printLadder(Ladder ladder) {
        System.out.println();
        System.out.println(RESULT_HEADER);
        System.out.println();
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        StringBuilder sb = new StringBuilder(EMPTY_SEGMENT);
        for (boolean point : line.getPoints()) {
            sb.append(VERTICAL_LINE);
            sb.append(drawPoint(point));
        }
        sb.append(VERTICAL_LINE);
        System.out.println(sb);
    }

    private String drawPoint(boolean point) {
        if (point) {
            return CONNECTED_SEGMENT;
        }
        return EMPTY_SEGMENT;
    }

    public void printResult(LadderResult result) {
        System.out.println();
        List<Integer> results = result.getResults();
        for (int i = 0; i < results.size(); i++) {
            System.out.printf(RESULT_FORMAT, i, results.get(i));
        }
    }
}
