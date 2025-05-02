package View;

import Domain.PlayerName;
import Domain.PlayerNames;
import Domain.PrizeName;
import Domain.PrizeNames;
import LadderDomain.Ladder;
import LadderDomain.Line;
import java.util.Map;

public class OutputHandler {

    private static final int BLANK_WIDTH = 6;

    public static void printLadder(PlayerNames playerNames, Ladder ladder,  PrizeNames prizeNames) {
        for (PlayerName playerName : playerNames.getAll()) {
            System.out.printf("%-" + BLANK_WIDTH + "s", playerName.getName());
        }
        System.out.println();

        for (Line line : ladder.getLines()) {
            printLine(line, playerNames.size());
        }

        for (PrizeName prize : prizeNames.getAll()) {
            System.out.printf("%-" + BLANK_WIDTH + "s", prize.getValue());
        }
        System.out.println();
    }

    private static void printLine(Line line, int width) {
        for (int i = 0; i < width - 1; i++) {
            System.out.print("|");
            System.out.print(line.getConnections().get(i).hasRight() ? "-----" : "     ");
        }
        System.out.println("|");
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
