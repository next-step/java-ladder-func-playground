package io.suhan.ladder.view;

import io.suhan.ladder.model.Connection;
import io.suhan.ladder.model.Ladder;
import io.suhan.ladder.model.Line;

public class OutputView {
    public static void printResult(Ladder ladder) {
        System.out.println("\n실행 결과\n");

        for (Line line : ladder.getLines()) {
            for (int i = 0; i < ladder.getWidth(); i++) {
                System.out.print("|");
                boolean connected = false;

                for (Connection connection : line.getConnections()) {
                    if (connection.getLeft() == i) {
                        connected = true;
                        break;
                    }
                }

                if (connected) {
                    System.out.print("----");
                } else {
                    System.out.print("    ");
                }
            }

            System.out.println();
        }
    }
}
