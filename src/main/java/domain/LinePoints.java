package domain;

import java.util.ArrayList;
import java.util.List;

public class LinePoints {
    private final List<PointConnection> points;

    public LinePoints(List<Boolean> raw) {
        List<PointConnection> converted = new ArrayList<>(raw.size());
        for (Boolean b : raw) {
            converted.add(new PointConnection(Boolean.TRUE.equals(b)));
        }
        checkNoduplicationTrue(converted);
        this.points = converted;
    }

    public List<PointConnection> getLinePoints() {
        return points;
    }

    private void checkNoduplicationTrue(List<PointConnection> points) {
        for (int i = 1; i < points.size(); i++)
            if (points.get(i - 1).isConnected() && points.get(i).isConnected()) {
                throw new IllegalArgumentException("인접한 사다리 연결");
            }
    }
}
