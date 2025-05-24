package view;

import domain.*;

import java.util.List;
import java.util.Map;

public class LadderView {
    public static void printLadderWithParticipants(Ladder ladder, Participants participants) {
        printParticipantsHeader(participants.getNames());
        printLadder(ladder);
    }

    private static void printParticipantsHeader(List<String> names) {
        StringBuilder sb = new StringBuilder("  ");
        for (String name : names) {
            sb.append(String.format("%-5s ", name));
        }
        System.out.println(sb);
    }

    private static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        StringBuilder builder = new StringBuilder("  ");
        for (Point point : line.getPoints()) {
            builder.append("|");
            builder.append(point.isConnected() ? "-----" : "     ");
        }
        builder.append("|");
        System.out.println(builder);
    }

    public static void printResultsWithPrizes(Participants participants, Results results, Map<Integer, Integer> gameResults) {
        StringBuilder sb = new StringBuilder("  ");
        for (int i = 0; i < participants.size(); i++) {
            int destination = gameResults.get(i);
            String prize = results.get(destination);
            sb.append(String.format("%-5s ", prize));
        }
        System.out.println(sb);
    }

    public static void printSingleResult(String name, String prize) {
        System.out.println("실행 결과");
        System.out.println(prize);
    }

    public static void printAllResults(Participants participants, Results results, Map<Integer, Integer> gameResults) {
        System.out.println("실행 결과");
        for (int i = 0; i < participants.size(); i++) {
            String name = participants.getNames().get(i);
            int destination = gameResults.get(i);
            String prize = results.get(destination);
            System.out.printf("%s : %s%n", name, prize);
        }
    }
}
