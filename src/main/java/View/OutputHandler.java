package View;

import Domain.PlayerName;
import Domain.Players;
import Domain.Result;
import LadderDomain.Ladder;
import LadderDomain.Line;
import java.util.Map;

public class OutputHandler {

    private static final int BLANK_WIDTH = 6;

    public static void printLadder(Players players, Ladder ladder, Result results) {
        for (PlayerName playerName : players.getAll()) {
            System.out.printf("%-" + BLANK_WIDTH + "s", playerName.getName());
        }
        System.out.println();

        for (Line line : ladder.getLines()) {
            printLine(line, players.size());
        }

        for (String result : results.getAll()) {
            System.out.printf("%-" + BLANK_WIDTH + "s", result);
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

    public static void printSingleResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public static void printResults(Map<PlayerName, String> resultMap) {
        resultMap.forEach((playerName, result) ->
                System.out.println(playerName.getName() + " : " + result)
        );
    }

    public static void printInvalidName() {
        System.out.println("존재하지 않는 이름입니다.");
    }
}
