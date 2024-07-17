package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Line {

    private final List<Boolean> points;

    private final Integer width;

    public Line(int width) {
        this.width = width;
        this.points = new ArrayList<>(width);
        initLine();
        initRung();
    }

    private void initLine() {
        for (int i = 0; i < width - 1; ++i) {
            this.points.add(false);
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private void initRung() {
        if (points.size() > 1) {
            points.set(0, createRandomBoolean());
        }
        for (int i = 1; i < points.size(); i++) {
            setRung(i);
        }
    }

    private void setRung(Integer column) {
        if (!Boolean.TRUE.equals(points.get(column - 1))) {
            points.set(column, createRandomBoolean());
        }
    }

    private boolean createRandomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    private String createRungString(boolean isRung) {
        if (isRung) {
            return "-".repeat(5);
        }
        return " ".repeat(5);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        points.forEach(point -> {
            stringBuilder.append("|");
            stringBuilder.append(createRungString(point));
        });
        stringBuilder.append("|");
        return stringBuilder.toString();
    }
}
