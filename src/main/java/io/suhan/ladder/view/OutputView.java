package io.suhan.ladder.view;

import io.suhan.ladder.model.Game;
import io.suhan.ladder.model.GameResult;
import io.suhan.ladder.model.Outcome;
import io.suhan.ladder.model.Participant;
import io.suhan.ladder.model.ladder.Ladder;
import io.suhan.ladder.model.ladder.Line;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printLadderResult(Game game) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();

        printParticipants(game.getConfiguration().participants());

        printLadder(game.getLadder(), game.getConfiguration().width());

        printOutcomes(game.getConfiguration().outcomes());
    }

    public static void printGameResult(GameResult result) {
        System.out.println();
        System.out.println("실행 결과");

        result.results()
                .forEach(((participant, outcome) -> System.out.println(participant.name() + " : " + outcome)));
    }

    public static void printGameResultOf(Participant target, GameResult result) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(result.getOutcome(target));
    }

    public static void printLadder(Ladder ladder, int width) {
        for (Line line : ladder.lines()) {
            String row = buildRow(line, width);

            System.out.println(row);
        }
    }

    private static void printParticipants(List<Participant> participants) {
        String line = participants.stream()
                .map((participant -> OutputView.centerAlign(participant.name())))
                .collect(Collectors.joining(" "));

        System.out.println(line);
    }

    private static void printOutcomes(List<Outcome> outcomes) {
        String line = outcomes.stream()
                .map((outcome -> OutputView.centerAlign(outcome.value())))
                .collect(Collectors.joining(" "));

        System.out.println(line);
    }

    private static String buildRow(Line line, int width) {
        StringBuilder builder = new StringBuilder();
        builder.append(" ".repeat(Participant.PARTICIPANT_NAME_MAX_LENGTH / 2));

        for (int i = 0; i < width; i++) {
            builder.append("|");

            String connectionSegment = getConnectionSegment(line, i);
            builder.append(connectionSegment);
        }

        return builder.toString();
    }

    private static String getConnectionSegment(Line line, int index) {
        if (isConnected(line, index)) {
            return "-----";
        }

        return "     ";
    }

    private static boolean isConnected(Line line, int index) {
        return line.connections().stream()
                .anyMatch((connection) -> connection.left() == index);
    }

    private static String centerAlign(String input) {
        int width = Participant.PARTICIPANT_NAME_MAX_LENGTH;

        int totalPadding = width - input.length();
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;

        return " ".repeat(leftPadding) + input + " ".repeat(rightPadding);
    }
}
