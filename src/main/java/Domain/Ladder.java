package Domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> line = new ArrayList<>();

    public Ladder(int width, int height) {
        for (int i = 0; i < height; i++) {
            line.add(new Line(width));
        }
    }

    public List<Line> getLines() {
        return line;
    }

    public int getResult(int startPosition) {
        int currentPosition = startPosition;

        for (Line line : line) {
            if (currentPosition > 0 && line.getPoints().get(currentPosition - 1)) {
                currentPosition--;
                continue;
            }
            if (currentPosition < line.getPoints().size() && line.getPoints().get(currentPosition)) {
                currentPosition++;
                continue;
            }
        }

        return currentPosition;
    }
}
