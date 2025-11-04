package view;

import model.ladder.Ladder;
import model.ladder.Line;
import model.participant.Player;
import model.participant.Players;
import model.result.GameResult;
import model.result.Prize;
import model.result.Prizes;

public class OutputView {
    private final Printer printer;

    private static final String CONNECTED_BAR = "-";
    private static final String DISCONNECTED_BAR = " ";
    private static final String VERTICAL_BAR = "|";
    private static final int LINE_WIDTH = 5;
    private static final String PLAYER_NAME_FORMAT = "%-5s"; // 6칸, 왼쪽 정렬

    public OutputView(Printer printer) {
        this.printer = printer;
    }

    public void printLadder(Ladder ladder, Players players, Prizes prizes) {
        printer.printLine(System.lineSeparator() + "사다리 결과");
        printPlayers(players);
        drawLadder(ladder);
        printPrizes(prizes);
    }

    private void printPlayers(Players players) {
        for (Player player : players.getPlayers()) { // 'asList' 사용 (Players 일급 컬렉션)
            printer.printFormat(PLAYER_NAME_FORMAT, player.getName());
        }
        printer.printLine();
    }

    private void drawLadder(Ladder ladder) {
        for (int i = 0; i < ladder.getHeight(); i++) {
            Line line = ladder.getLine(i);
            drawLine(line);
        }
    }

    private void drawLine(Line line) {
        printer.print(VERTICAL_BAR);
        int pointCount = line.getPointCount();
        for (int i = 0; i < pointCount; i++) {
            drawFoothold(line.isConnectedAt(i));
        }
        printer.printLine();
    }

    private void drawFoothold(boolean isConnected) {
        if (isConnected) {
            printer.print(CONNECTED_BAR.repeat(LINE_WIDTH));
            printer.print(VERTICAL_BAR);
            return;
        }
        printer.print(DISCONNECTED_BAR.repeat(LINE_WIDTH));
        printer.print(VERTICAL_BAR);
    }

    private void printPrizes(Prizes prizes) {
        for (Prize prize : prizes.getPrizes()) {
            printer.printFormat(PLAYER_NAME_FORMAT, prize.getValue());
        }
        printer.printLine(System.lineSeparator());
    }

    public void printSingleResult(GameResult result, String playerName) {
        printer.printLine(System.lineSeparator() + "실행 결과");

        Prize prize = result.getDestination(playerName);

        if (prize == null) {
            printer.printError("'" + playerName + "'에 해당하는 결과를 찾을 수 없습니다.");
            return;
        }
        printer.printLine(prize.getValue());
    }

    public void printAllResults(GameResult result, Players players) {
        printer.printLine(System.lineSeparator() + "실행 결과");
        for (Player player : players.getPlayers()) {
            String name = player.getName();
            Prize prize = result.getDestination(name);

            printer.printLine(name + " : " + prize.getValue());

        }
    }

    public void printError(String errorMessage) {
        printer.printError(errorMessage);
    }
}
