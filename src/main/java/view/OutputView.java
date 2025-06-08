package view;

import domain.dto.ResponseLadder;
import domain.dto.ResponseLadderResult;
import domain.dto.ResponseLine;

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

    public static void drawLadder(final ResponseLadder ladder) {
        for (ResponseLine line : ladder.lines()) {
            drawLine(line);
        }
    }

    private static void drawLine(final ResponseLine line) {
        StringBuilder builder = new StringBuilder();
        builder.append(BLANK);

        for (boolean connected : line.connections()) {
            builder.append(VERTICAL);
            builder.append(drawHorizontalIfConnected(connected));
        }

        builder.append(VERTICAL);
        System.out.println(builder);
    }

    private static String drawHorizontalIfConnected(final boolean connected) {
        if (connected) {
            return HORIZONTAL;
        }
        return BLANK;
    }

    public static void printLadderResult(final ResponseLadderResult result) {
        System.out.println();
        for (String line : result.results()) {
            System.out.println(line);
        }
    }
}
