package View;

import Domain.Name;
import Domain.Player;
import Domain.Players;
import Domain.Result;
import Domain.Results;
import LadderDomain.Ladder;
import LadderDomain.Line;
import java.util.Map;

public class OutputHandler {

    private static final int CELL_WIDTH = 6;

    public static void printLadder(Players players, Ladder ladder, Results results) {
        for (Player player : players.getAll()) {
            System.out.printf("%-" + CELL_WIDTH + "s", player.getName().getValue());
        }
        System.out.println();

        for (Line line : ladder.getLines()) {
            printLine(line, players.size());
        }

        for (Result result : results.getAll()) {
            System.out.printf("%-" + CELL_WIDTH + "s", result.getValue());
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

    public static  void printSingleResult(Result result) {
        System.out.println("실행 결과");
        System.out.println(result.getValue());
    }

    public static void printResults(Map<Name, Result> resultMap) {
        resultMap.forEach((name, result) ->
                System.out.println(name.getValue() + " : " + result.getValue())
        );
    }

    public static void printInvalidName() {
        System.out.println("존재하지 않는 이름입니다.");
    }
}
