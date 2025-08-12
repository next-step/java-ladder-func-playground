package view;

import model.Line;
import model.Player;

import java.util.*;

public class ResultView {
    public static void printLadder(List<Player> players, List<Line> lines, List<String> results) {
        for (Player player : players) {
            System.out.printf("%6s", player.getName());
        }
        System.out.println();

        for (Line line : lines) {
            printLine(line);
        }

        for (String result : results) {
            System.out.printf("%6s", result);
        }
        System.out.println();
    }

    private static void printLine(Line line) {
        System.out.print("    ");
        for (boolean point : line.getPoints()) {
            System.out.print(point ? " |-----" : " |     ");
        }
        System.out.println(" |");
    }

    public static void printResult(String name, String result) {
        System.out.println("실행 결과");
        System.out.println(name + " : " + result);
    }

    public static void printAllResults(Map<String, String> results) {
        System.out.println("실행 결과");
        results.forEach((name, result) -> System.out.println(name + " : " + result));
    }
}
