package view;

import java.util.List;

public class ResultView {
    private static final String LADDER_RESULT_HEADER = "사다리 결과";
    private static final String RESULT_HEADER = "실행결과";
    public static final String NAME_FORMAT = "%6s";
    private static final String VERTICAL_LINE = "|";
    private static final String CONNECTED_SEGMENT = "-----";
    private static final String EMPTY_SEGMENT = "     ";

    public void printLadder(LadderDisplayDto displayDto) {
        System.out.println();
        System.out.println(LADDER_RESULT_HEADER);
        printPlayerNames(displayDto.playerNames());
        for (List<Boolean> points : displayDto.lines()) {
            printLine(points);
        }
        printRewardNames(displayDto.rewardNames());
    }

    private void printPlayerNames(List<String> playerNames) {
        System.out.println();
        for (String name : playerNames) {
            System.out.printf(NAME_FORMAT, name);
        }
        System.out.println();
    }

    private void printLine(List<Boolean> points) {
        StringBuilder sb = new StringBuilder(EMPTY_SEGMENT);
        for (boolean point : points) {
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

    private void printRewardNames(List<String> rewardNames) {
        for (String result : rewardNames) {
            System.out.printf(NAME_FORMAT, result);
        }
    }

    public void printAllResults(List<PlayerResultDto> resultsDto) {
        System.out.println();
        System.out.println(RESULT_HEADER);
        for (PlayerResultDto result : resultsDto) {
            System.out.println(result.name() + " : " + result.result());
        }
    }

    public void printSingleResult(PlayerResultDto resultDto) {
        System.out.println();
        System.out.println(RESULT_HEADER);
        System.out.println(resultDto.result());
    }
}
