package io.suhan.ladder.view;

import io.suhan.ladder.model.Game;
import io.suhan.ladder.model.GameResult;
import io.suhan.ladder.model.Line;
import io.suhan.ladder.model.Participant;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printLadder(Game game) {
        System.out.println("\n사다리 결과\n");

        printParticipants(game.getConfiguration().getParticipants());

        for (Line line : game.getLadder().getLines()) {
            String row = buildRow(line, game.getConfiguration().getWidth());

            System.out.println(row);
        }

        printOutcomes(game.getConfiguration().getOutcomes());
    }

    public static void printGameResult(GameResult result) {
        System.out.println("\n실행 결과");

        result.getResults()
                .forEach(((participant, outcome) -> System.out.println(participant.getName() + " : " + outcome)));
    }

    public static void printGameResultOf(Participant target, GameResult result) {
        System.out.println("\n실행 결과");
        System.out.println(result.getOutcome(target));
    }

    private static void printParticipants(List<Participant> participants) {
        String line = participants.stream()
                .map((participant -> OutputView.centerAlign(participant.getName())))
                .collect(Collectors.joining(" "));

        System.out.println(line);
    }

    private static void printOutcomes(List<String> outcomes) {
        String line = outcomes.stream()
                .map(OutputView::centerAlign)
                .collect(Collectors.joining(" "));

        System.out.println(line);
    }

    public static void printTraverseResult(int start, int end) {
        System.out.println(start + " -> " + end);
    }

    private static String buildRow(Line line, int width) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ".repeat(Participant.PARTICIPANT_NAME_MAX_LENGTH / 2));

        for (int i = 0; i < width; i++) {
            builder.append("|");

            if (isConnected(line, i)) {
                builder.append("-----");
            } else {
                builder.append("     ");
            }
        }

        return builder.toString();
    }

    private static boolean isConnected(Line line, int index) {
        return line.getConnections().stream()
                .anyMatch((connection) -> connection.getLeft() == index);
    }

    private static String centerAlign(String input) {
        int width = Participant.PARTICIPANT_NAME_MAX_LENGTH;

        int totalPadding = width - input.length();
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;

        return " ".repeat(leftPadding) + input + " ".repeat(rightPadding);
    }
}
