package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Point> points;
    private final Random random = new Random();

    public Line(Size lineSize) {
        this.points = generatePoints(lineSize);
        duplicationCheck(this.points);
    }

    public Line(List<Point> points) {
        duplicationCheck(points);
        this.points = points;
    }

    private List<Point> generatePoints(Size lineSize) {
        List<Point> points = new ArrayList<>();
        for (int i = 1; i < lineSize.getSize(); i++) {
            generatePoint(points);
        }
        return points;
    }

    private void generatePoint(List<Point> points) {
        if (points.isEmpty()) {
            points.add(new Point(getRandomBoolean()));
            return;
        }
        generateNext(points);
    }

    private void generateNext(List<Point> points) {
        boolean isConnected = false;
        int lastIndex = points.size() - 1;
        if (!points.get(lastIndex).isConnected()) {
            isConnected = getRandomBoolean();
        }
        points.add(new Point(isConnected));
    }

    private boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    private void duplicationCheck(List<Point> points) {
        boolean result = false;
        boolean before = false;
        for (Point point : points) {
            result = result || (before && point.isConnected());
            before = point.isConnected();
        }
        isDuplicate(result);
    }

    private void isDuplicate(boolean result) {
        if (result) {
            throw new RuntimeException("사다리 가로라인은 겹칠 수 없습니다.");
        }
    }

    public List<Point> getPoints() {
        return points;
    }
}
