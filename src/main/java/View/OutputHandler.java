package View;

import Domain.PlayerName;
import Domain.PlayerNames;
import Domain.PrizeName;
import Domain.PrizeNames;
import LadderDomain.Ladder;
import LadderDomain.LadderRow;
import java.util.Map;

public class OutputHandler {

    private static final int BLANK_WIDTH = 6;

    public static void printLadder(PlayerNames playerNames, Ladder ladder,  PrizeNames prizeNames) {
        for (PlayerName playerName : playerNames.getAll()) {
            System.out.printf("%-" + BLANK_WIDTH + "s", playerName.getName());
        }
        System.out.println();

        for (LadderRow ladderRow : ladder.getLines()) {
            printLine(ladderRow, playerNames.size());
        }

        for (PrizeName prize : prizeNames.getAll()) {
            System.out.printf("%-" + BLANK_WIDTH + "s", prize.getValue());
        }
        System.out.println();
    }

    private static void printLine(LadderRow ladderRow, int width) {
        for (int i = 0; i < width - 1; i++) {
            System.out.print("|");
            printConnection(ladderRow.getConnections().get(i).hasRight());
        }
        System.out.println("|");
    }

    private static void printConnection(boolean hasRight) {
        String segment = getConnectionString(hasRight);
        System.out.print(segment);
    }

    private static String getConnectionString(boolean connected) {
        if (connected) {
            return "-----";
        }
        return "     ";
    }
    public static void printSingleResult(PrizeName prize) {
        System.out.println("실행 결과");
        System.out.println(prize.getValue());
    }

    public static void printResults(PlayerNames playerNames, Map<PlayerName, PrizeName> resultMap) {
        for (PlayerName name : playerNames.getAll()) {
            PrizeName prize = resultMap.get(name);
            System.out.println(name.getName() + " : " + prize.getValue());
        }
    }

    public static void printInvalidName() {
        System.out.println("존재하지 않는 이름입니다.");
    }
}
