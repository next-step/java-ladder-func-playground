package view;

import ladder.Ladder;
import ladder.Line;
import ladder.Link;
import people.People;
import people.Person;
import result.LadderResult;
import result.Prize;
import result.Prizes;

public class OutputView {
    private static final String CONNECTED = "-----";
    private static final String DISCONNECTED = "     ";
    private static final String VERTICAL_BAR = "|";
    private static final String LEFT_MARGIN = "    ";
    private static final int COLUMN_WIDTH = 6;

    private OutputView() {
    }

    public static void printLadder(Ladder ladder, People people, Prizes prizes) {
        System.out.println("사다리 결과");
        System.out.println();

        printNames(people);
        ladder.getLines().forEach(OutputView::printLine);
        printPrizes(prizes);
    }

    private static void printNames(People people) {
        StringBuilder sb = new StringBuilder(LEFT_MARGIN);
        for (Person person : people.values()) {
            sb.append(String.format("%-" + COLUMN_WIDTH + "s", person.name()));
        }
        System.out.println(sb);
    }

    private static void printPrizes(Prizes prizes) {
        StringBuilder sb = new StringBuilder(LEFT_MARGIN);
        for (Prize prize : prizes.values()) {
            sb.append(String.format("%-" + COLUMN_WIDTH + "s", prize.value()));
        }
        System.out.println(sb);
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
        if(isLinked){
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public static void printResult(LadderResult result) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        result.result().forEach((start, end) ->
                sb.append(start)
                        .append(" -> ")
                        .append(end)
                        .append(System.lineSeparator())
        );
        System.out.print(sb);
    }
}




