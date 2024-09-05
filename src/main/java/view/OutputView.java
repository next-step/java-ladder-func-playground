package view;


import java.util.List;
import java.util.Set;

public class OutputView {

    private static final String START_LINE = "|";

    private static final String BLANK_LINE = "    |";
    private static final String RUNG_LINE = "----|";


    public void printStatusOfLadders(List<Set<Integer>> rungPositionsPerLadder, int height) {
        for (int nowPosition = height - 1; nowPosition >= 0; nowPosition--) {
            System.out.print(START_LINE);
            printStatusAtLadderPosition(rungPositionsPerLadder, nowPosition);
            System.out.println();
        }
    }

    private void printStatusAtLadderPosition(List<Set<Integer>> rungPositionsPerLadder, int nowPosition) {
        for (Set<Integer> rungPositions : rungPositionsPerLadder) {
            System.out.print(createOrSkip(rungPositions, nowPosition));
        }
    }

    private String createOrSkip(Set<Integer> rungPosition, int nowPosition) {
        if (rungPosition.contains(nowPosition)) {
            return RUNG_LINE;
        }
        return BLANK_LINE;
    }


}
