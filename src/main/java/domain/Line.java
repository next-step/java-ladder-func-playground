package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    public static final String ERROR_DUPLICATE_LINES = "가로 라인은 겹치지 않아야합니다.";
    private static final Random random = new Random();
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        validateLine(points);
        this.points = points;
    }

    public static Line generate(int width) {
        List<Boolean> points = new ArrayList<>();
        boolean previous = false;

        for (int i = 0; i < width - 1; i++) {
            boolean current = !previous && random.nextBoolean();
            points.add(current);
            previous = current;
        }

        return new Line(points);
    }

    private void validateLine(List<Boolean> points) {
        boolean previous = false;
        for (boolean current : points) {
            if (previous && current) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_LINES);
            }
            previous = current;
        }
    }

    public int move(int position) {
        if (position < points.size() && points.get(position)) {
            return position + 1;
        }
        if (position > 0 && points.get(position - 1)) {
            return position - 1;
        }
        return position;
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }

    public int getWidth() {
        return points.size() + 1;
    }
}
