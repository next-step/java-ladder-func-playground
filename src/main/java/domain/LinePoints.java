package domain;

import java.util.List;

public class LinePoints {
    private final List<Boolean> points;

    public LinePoints(List<Boolean> points) {
        checkNoduplicationTrue(points);
        this.points = points;
    }

    public List<Boolean> getLinePoints() {
        return points;
    }

    private void checkNoduplicationTrue(List<Boolean> points) {
        for (int i = 1; i < points.size(); i++)
            if (Boolean.TRUE.equals(points.get(i - 1)) && Boolean.TRUE.equals(points.get(i)))
                throw new IllegalArgumentException("인접한 사다리 연결");
    }
}
