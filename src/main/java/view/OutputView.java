package view;

import domain.Ladder;
import domain.Line;

public class OutputView {

    private static final String GAME_RESULT_COMMAND = "실행결과";
    private static final String VERTICAL_BAR = "|";
    private static final String BRIDGE_SEGMENT = "-----";
    private static final String EMPTY_SEGMENT = "     ";
    private static final String ARROW_STR = "->";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String NEW_SPACE = " ";

    public void printLadderWidth() {
        print("사다리의 넓이는 몇 개인가요?");
    }

    public void printLadderHeight() {
        print("사다리의 높이는 몇 개인가요?");
    }

    public void printLadderGameResult(Ladder ladder, int width) {
        print(GAME_RESULT_COMMAND);

        for (Line line : ladder.lines()) {
            print(renderLine(line));
        }

        print(getMatchingResult(ladder, width));
    }

    private String renderLine(Line line) {
        StringBuilder sb = new StringBuilder();
        sb.append(VERTICAL_BAR);

        for (boolean hasBridge : line.points()) {
            sb.append(segmentFor(hasBridge));
            sb.append(VERTICAL_BAR);
        }

        return sb.toString();
    }

    private String segmentFor(boolean hasBridge) {
        if (hasBridge) {
            return BRIDGE_SEGMENT;
        }
        return EMPTY_SEGMENT;
    }

    private String getMatchingResult(Ladder ladder, int width) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < width; i++) {
            sb.append(i);
            sb.append(NEW_SPACE);
            sb.append(ARROW_STR);
            sb.append(NEW_SPACE);
            sb.append(ladder.getDestination(i));
            sb.append(NEW_LINE);
        }

        return sb.toString();
    }

    private void print(String value) {
        System.out.println(value);
    }

}
