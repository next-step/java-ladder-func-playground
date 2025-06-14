package view;

import ladder.Ladder;
import ladder.LadderGame;
import ladder.Line;
import ladder.Link;
import people.People;
import people.Person;
import result.LadderResult;
import result.Prize;
import result.Prizes;

import java.util.Map;

public class OutputView {
    private static final String CONNECTED = "-----";
    private static final String DISCONNECTED = "     ";
    private static final String VERTICAL_BAR = "|";
    private static final String LEFT_MARGIN = "    ";
    private static final int COLUMN_WIDTH = 6;
    private static final String NEW_LINE = System.lineSeparator();

    private OutputView() {
    }

    public static void printLadder(Ladder ladder, People people, Prizes prizes) {
        StringBuilder sb = new StringBuilder();

        sb.append(NEW_LINE).append("사다리 결과").append(NEW_LINE).append(NEW_LINE);
        sb.append(namesLine(people));
        ladder.getLines().forEach(line -> sb.append(ladderLine(line)));
        sb.append(prizesLine(prizes));

        System.out.print(sb);
    }

    private static String namesLine(People people) {
        StringBuilder sb = new StringBuilder(LEFT_MARGIN);
        for (Person person : people.values()) {
            sb.append(String.format("%-" + COLUMN_WIDTH + "s", person.name()));
        }
        sb.append(NEW_LINE);
        return sb.toString();
    }

    private static String prizesLine(Prizes prizes) {
        StringBuilder sb = new StringBuilder(LEFT_MARGIN);
        for (Prize prize : prizes.values()) {
            sb.append(String.format("%-" + COLUMN_WIDTH + "s", prize.value()));
        }
        sb.append(NEW_LINE);
        return sb.toString();
    }

    private static String ladderLine(Line line) {
        StringBuilder sb = new StringBuilder(LEFT_MARGIN);
        for (Link link : line.getLinks()) {
            sb.append(VERTICAL_BAR);
            sb.append(renderLink(link.isLinked()));
        }
        sb.append(VERTICAL_BAR).append(NEW_LINE);
        return sb.toString();
    }

    private static String renderLink(boolean isLinked) {
        if(isLinked){
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public static void printSingleResult(String prizeValue) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator())
                .append("실행 결과").append(System.lineSeparator())
                .append(prizeValue).append(System.lineSeparator());
        System.out.print(sb);
    }

    public static void printAllResults(Map<String, String> resultMap) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator()).append("실행 결과").append(System.lineSeparator());
        resultMap.forEach((name, prize) ->
                sb.append(name).append(" : ").append(prize).append(System.lineSeparator())
        );
        System.out.print(sb);
    }

}




