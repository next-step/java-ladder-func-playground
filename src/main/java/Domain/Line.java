package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> points = new ArrayList<>();
    private Random random = new Random();
    boolean beforeHasLine = false;

    public List<Boolean> getPoints() {
        return points;
    }

    public Line(int width) {
        for (int i = 1; i < width; i++) {
            boolean hasLine = random.nextBoolean();
            if (beforeHasLine) {
                hasLine = false;
            }
            points.add(hasLine);
            beforeHasLine = hasLine;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for (Boolean point : points) {
            sb.append(point ? "-----" : "     ");
            sb.append("|");
        }
        return sb.toString();
    }
}
