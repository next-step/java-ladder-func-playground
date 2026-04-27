package domain;

import domain.strategy.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    private Line(int width, BooleanGenerator booleanGenerator) {
        validateWidth(width);
        this.points = new ArrayList<>();

        for (int i = 0; i < width - 1; i++) {
            boolean step = drawStep(i, booleanGenerator);
            points.add(step);
        }
    }

    public static Line create(int width, BooleanGenerator booleanGenerator) {
        return new Line(width, booleanGenerator);
    }

    public List<Boolean> getPoints() {
        return List.copyOf(points);
    }

    public int move(int index) {
        if (index < points.size() && points.get(index)) {
            return index + 1;
        }
        if (index > 0 && points.get(index - 1)) {
            return index - 1;
        }
        return index;
    }

    private boolean drawStep(int index, BooleanGenerator booleanGenerator) {
        if (index > 0 && points.get(index - 1)) {
            return false;
        }
        return booleanGenerator.generate();
    }

    private void validateWidth(int width) {
        if (width < 2) {
            throw new IllegalArgumentException("사다리 너비는 2 이상이어야 합니다.");
        }
    }
}
