package io.suhan.ladder;

import io.suhan.ladder.model.Connection;
import io.suhan.ladder.model.Ladder;
import io.suhan.ladder.model.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<Line> lines = new ArrayList<>();

        int width = 4;
        int height = 4;

        for (int i = 0; i < height; i++) {
            List<Connection> connections = new ArrayList<>();
            int j = 0;

            while (j < width - 1) {
                boolean value = random.nextBoolean();

                if (value) {
                    connections.add(new Connection(j, j + 1));
                    j += 2;
                } else {
                    j += 1;
                }
            }

            lines.add(new Line(connections));
        }

        Ladder ladder = new Ladder(lines);

        for (Line line : ladder.getLines()) {
            for (int i = 0; i < width; i++) {
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
