package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(Size size) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < size.getHeight()-1; i++) {
            lines.add(Line.create(size.getWidth()));
        }
        ensureConnections(lines, size.getWidth());
        return new Ladder(lines);
    }

    private static void ensureConnections(List<Line> lines, int width) {
        for (int col = 0; col < width - 1; col++) {
            addConnectionIfAbsent(lines, col);
        }
    }

    private static void addConnectionIfAbsent(List<Line> lines, int col) {
        boolean hasConnection = checkConnectionInColumn(lines, col);
        if (hasConnection) {
            return;
        }
        int randomLineIndex = new Random().nextInt(lines.size());
        lines.get(randomLineIndex).forceConnect(col);
    }

    private static boolean checkConnectionInColumn(List<Line> lines, int col) {
        for (Line line : lines) {
            if (line.getPoints().get(col).isConnected()) {
                return true;
            }
        }
        return false;
    }


    public int move(int position) {
        int current = position;
        for (Line line : lines) {
            current = line.move(current);
        }
        return current;
    }

    public List<Line> getLines() {
        return lines;
    }
}
