package view;

import static enumurate.LadderElementEnum.*;

import java.util.Map;

import domain.Ladder;
import domain.LadderGame;
import domain.Line;
import enumurate.LadderElementEnum;

public class ResultView {

    public static void outputLines(LadderGame ladderGame) {
        System.out.println(ladderGame.getPlayers());
        for (Line line : ladderGame.getLadder().getLines()) {
            printLine(line);
        }
        System.out.println(ladderGame.getPrizes());
    }

    private static void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        sb.append(VERTICAL);
        for (Boolean point : line.getPoints()) {
            sb.append(getElement(point));
            sb.append(VERTICAL);
        }
        System.out.println(sb);
    }

    private static LadderElementEnum getElement(Boolean point) {
        if (point) {
            return CONNECTED;
        }
        return DISCONNECTED;
    }

    public static void outputResult(String playerName, LadderGame ladderGame) {
        System.out.println("실행 결과");
        if (playerName.equals("all")) {
            outputAllResult(ladderGame);
            return;
        }
        outputPlayerResult(playerName, ladderGame);
    }

    private static void outputAllResult(LadderGame ladderGame) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : ladderGame.getResults().entrySet()) {
            sb.append(entry.getKey())
                .append(" : ")
                .append(entry.getValue())
                .append(System.lineSeparator());
        }
        System.out.print(sb);
    }

    private static void outputPlayerResult(String player, LadderGame ladderGame) {
        String prize = ladderGame.getResults().get(player);
        System.out.println(prize);
    }
}
