package io.suhan.ladder.view;

import io.suhan.ladder.model.Ladder;
import io.suhan.ladder.model.Line;

public class OutputView {
    public static void printResult(Ladder ladder) {
        System.out.println("\n실행 결과\n");

        for (Line line : ladder.getLines()) {
            String row = buildRow(line, ladder.getWidth());

            System.out.println(row);
        }
    }

    public static void printTraverseResult(int start, int end) {
        System.out.println(start + " -> " + end);
    }

    private static String buildRow(Line line, int width) {
        StringBuilder builder = new StringBuilder();

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
}
