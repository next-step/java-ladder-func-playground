package view;

import domain.user.PlayerName;
import domain.user.PlayerNames;
import domain.prize.PrizeName;
import domain.prize.PrizeNames;
import ladderdomain.Connection;
import ladderdomain.Ladder;
import ladderdomain.LadderRow;
import java.util.Map;

public class OutputHandler {

    private static final int BLANK_WIDTH = 6;

    public static void printLadder(PlayerNames playerNames, Ladder ladder, PrizeNames prizeNames) {
        playerNames.streamWithIndex()
                .forEach(ipn -> System.out.printf("%-" + BLANK_WIDTH + "s", ipn.name().getName()));
        System.out.println();

        ladder.getLines().forEach(row -> printLine(row, playerNames.size()));

        prizeNames.getAll().stream()
                .forEach(prize -> System.out.printf("%-" + BLANK_WIDTH + "s", prize.getValue()));
        System.out.println();
    }

    private static void printLine(LadderRow ladderRow, int width) {
        StringBuilder builder = new StringBuilder();
        ladderRow.getConnections().stream()
                .limit(width - 1)
                .map(Connection::hasRight)
                .map(OutputHandler::getLine)
                .forEach(builder::append);
        builder.append("|");
        System.out.println(builder);
    }

    private static String getLine(boolean hasRight) {
        return "|" + getConnectionString(hasRight);
    }

    private static String getConnectionString(boolean connected) {
        if (connected) {
            return "-----";
        }
        return "     ";
    }
    public static void printSingleResult(PrizeName prize) {
        System.out.println("\n실행 결과");
        System.out.println(prize.getValue());
    }

    public static void printResults(PlayerNames playerNames, Map<PlayerName, PrizeName> resultMap) {
        playerNames.streamWithIndex()
                .forEach(ipn -> {
                    PrizeName prize = resultMap.get(ipn.name());
                    System.out.println(ipn.name().getName() + " : " + prize.getValue());
                });
    }

    public static void printInvalidName() {
        System.out.println("존재하지 않는 이름입니다.\n");
    }
}
