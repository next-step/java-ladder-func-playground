package view;

import ladder.Ladder;
import ladder.Line;
import ladder.Link;

public class OutputView {
    private static final String CONNECTED = "-----";
    private static final String DISCONNECTED = "     ";
    private static final String VERTICAL_BAR = "|";
    private static final String LEFT_MARGIN = "    ";

    private OutputView() {
    }

    public static void printLadder(Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();
        ladder.getLines().forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        StringBuilder sb = new StringBuilder(LEFT_MARGIN);
        for (Link link : line.getLinks()) {
            sb.append(VERTICAL_BAR);
            sb.append(renderLink(link.isLinked()));
        }
        sb.append(VERTICAL_BAR);
        System.out.println(sb);
    }

    private static String renderLink(boolean isLinked) {
        return isLinked ? CONNECTED : DISCONNECTED;
    }
}




