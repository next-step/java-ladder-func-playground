package view;

import domain.Ladder;
import domain.LadderResult;
import domain.Line;
import domain.Players;
import domain.Results;

public class ResultView {
    private static final String LADDER_RESULT_HEADER = "사다리 결과";
    private static final String RESULT_HEADER = "실행결과";
    public static final String NAME_FORMAT = "%6s";
    private static final String VERTICAL_LINE = "|";
    private static final String CONNECTED_SEGMENT = "-----";
    private static final String EMPTY_SEGMENT = "     ";

    public void printLadder(Ladder ladder, Players players, Results results) {
        System.out.println();
        System.out.println(LADDER_RESULT_HEADER);
        printNames(players);
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
        printResults(results);
    }

    private void printNames(Players players) {
        System.out.println();
        for (String name : players.getPlayerNames()) {
            System.out.printf(NAME_FORMAT, name);
        }
        System.out.println();
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

    private void printResults(Results results) {
        for (String result : results.getResults()) {
            System.out.printf(NAME_FORMAT, result);
        }
    }

    public void printResult(LadderResult ladderResult, String targetName) {
        System.out.println();
        System.out.println(RESULT_HEADER);
        if (targetName.equals("all")) {
            ladderResult.getResults().forEach((name, result) ->
                    System.out.println(name + " : " + result)
            );
            return;
        }
        System.out.println(ladderResult.getResult(targetName));
    }
}
