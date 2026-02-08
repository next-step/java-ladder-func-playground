package ladder.view;

import java.util.Map;
import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.LadderResults;
import ladder.domain.Line;
import ladder.domain.Name;
import ladder.domain.Participants;
import ladder.domain.Point;

public class OutputView {

    private static final String VERTICAL_BAR = "|";
    private static final String BRIDGE = "-----";
    private static final String EMPTY = "     ";

    public static void printLadder(Participants participants, Ladder ladder, LadderResults results) {
        System.out.println("\n사다리 결과\n\n");

        printParticipants(participants);

        ladder.getLines().forEach(OutputView::printLine);

        printLadderResults(results);
    }

    private static void printParticipants(Participants participants) {
        participants.getValues().forEach(name ->
            System.out.print(format(name.getName()))
        );
        System.out.println();
    }

    private static void printLadderResults(LadderResults results) {
        results.getValues().forEach(result ->
            System.out.print(format(result.getValue()))
        );
        System.out.println();
    }

    private static String format(String value) {
        return String.format("%6s", value);
    }

    private static void printLine(Line line) {
        System.out.print("     " + VERTICAL_BAR);
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

    public static void printSingleResult(String result) {
        System.out.println("\n실행 결과");
        System.out.println(result);
    }

    public static void printAllResults(Map<Name, LadderResult> results) {
        System.out.println("\n실행 결과");
        results.forEach((name, result) ->
            System.out.println(name.getName() + " : " + result.getValue())
        );
    }
}
