package view;

import domain.dto.ResponseLadder;
import domain.dto.ResponseLine;
import domain.ladder.result.LadderResultBoard;
import domain.player.Players;
import domain.runningResult.Results;

public final class OutputView {

    private static final String LADDER_RESULT_TITLE = "사다리 결과";
    private static final String RUNNING_RESULT_TITLE = "실행 결과";
    private static final int CELL_WIDTH = 6;

    private static final String BLANK = "     ";
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-----";

    private OutputView() {
    }

    public static void printPlayerNames(final Players players) {
        System.out.print(BLANK);
        players.values().forEach(player ->
                System.out.print(padding(player.name().value()))
        );
        System.out.println();
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

    public static void printResults(final Results results) {
        System.out.print(BLANK);
        results.asList().forEach(result ->
                System.out.print(padding(result.value()))
        );
        System.out.println();
    }

    public static void printSingleLadderResult(final LadderResultBoard resultBoard, final String playerName) {
        System.out.println();
        System.out.println(RUNNING_RESULT_TITLE);
        String result = resultBoard.findResultOf(playerName)
                .orElse("존재하지 않는 플레이어입니다.");
        System.out.println(result);
    }

    public static void printAllLadderResult(final LadderResultBoard resultBoard) {
        System.out.println();
        System.out.println(RUNNING_RESULT_TITLE);
        resultBoard.getAllResults().forEach(ladderResult ->
                System.out.println(ladderResult.playerName() + " : " + ladderResult.result()));
    }

    private static String padding(final String text) {
        return String.format("%-" + CELL_WIDTH + "s", text);
    }
}
