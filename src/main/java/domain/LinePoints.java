package domain;
import java.util.List;

public class LinePoints {
    private final List<Boolean> points;

    public LinePoints(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getLinePoints() {
        return points;
    }
}
