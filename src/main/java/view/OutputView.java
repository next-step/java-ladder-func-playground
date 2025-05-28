package view;

import ladder.Ladder;
import ladder.Line;
import ladder.Link;

public class OutputView {
    private static final String LEFT_MARGIN = "    |";
    private static final String CONNECTED = "-----|";
    private static final String DISCONNECTED = "     |";

    private OutputView() {
    }

    public static void printLadder(Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();
        ladder.getLines().forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        System.out.print(LEFT_MARGIN);
        line.getLinks().forEach(OutputView::printLink);
        System.out.println();
    }

    private static void printLink(Link link) {
        String symbol = DISCONNECTED;
        if (link.isLinked()) {
            symbol = CONNECTED;
        }
        System.out.print(symbol);
    }
}




