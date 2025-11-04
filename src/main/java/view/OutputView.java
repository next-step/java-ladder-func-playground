package view;

import model.ladder.Ladder;
import model.ladder.Line;
import model.participant.Player;
import model.participant.Players;
import model.result.GameResult;
import model.result.Prize;
import model.result.Prizes;

public class OutputView {
    private static final String CONNECTED_BAR = "-";
    private static final String DISCONNECTED_BAR = " ";
    private static final String VERTICAL_BAR = "|";
    private static final int LINE_WIDTH = 5;

    public void printLadder(Ladder ladder, Players players, Prizes prizes) {
        System.out.println(System.lineSeparator() + "사다리 결과");
        printPlayers(players);
        drawLadder(ladder);
        printPrizes(prizes);
    }

    private void printPlayers(Players players) {
        for (Player player : players.getPlayers()) {
            System.out.printf("%-5s", player.getName());
        }
        System.out.println();
    }

    private void drawLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            System.out.print(VERTICAL_BAR);
            Line line = ladder.getLine(i);
            drawLine(line);
        }
    }

    private void drawLine(Line line) {
        int pointCount = line.getPointCount();
        for (int i = 0; i < pointCount; i++) {
            drawFoothold(line.isConnectedAt(i));
        }
        System.out.println("");
    }

    private void drawFoothold(boolean isConnected) {
        if (isConnected) {
            System.out.printf(CONNECTED_BAR.repeat(LINE_WIDTH) + VERTICAL_BAR);
            return;
        }
        System.out.print(DISCONNECTED_BAR.repeat(LINE_WIDTH) + VERTICAL_BAR);
    }


    private void printPrizes(Prizes prizes) {
        for (Prize prize : prizes.getPrizes()) {
            System.out.printf("%-5s", prize.getValue());
        }
        System.out.println(System.lineSeparator());
    }

    public void printSingleResult(GameResult result, String playerName) {
        System.out.println(System.lineSeparator() + "실행 결과");

        Prize prize = result.getDestination(playerName);
        System.out.println(prize.getValue());
    }

    public void printAllResults(GameResult result, Players players) {
        System.out.println(System.lineSeparator() + "실행 결과");
        for (Player player : players.getPlayers()) {
            String name = player.getName();
            Prize prize = result.getDestination(name);
            System.out.println(name + " : " + prize.getValue());
        }
    }

    public void printError(String errorMessage) {
        System.err.println(errorMessage);
    }
}
