package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Point> points;

    public Line(Size lineSize) {
        this(PointsGenerator.generatePoints(lineSize));
    }

    public Line(List<Point> points) {
        duplicationCheck(points);
        this.points = points;
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
