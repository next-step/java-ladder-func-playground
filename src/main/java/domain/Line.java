package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Point> points;

    private Line(List<Point> points) {
        this.points = points;
    }

    public static Line create(int width) {
        List<Point> points = new ArrayList<>();
        Random random = new Random();
        boolean previousConnected = false;

        for (int i = 0; i < width - 1; i++) {
            boolean connect = !previousConnected && random.nextBoolean();
            points.add(Point.of(connect));
            previousConnected = connect;
        }
        points.add(Point.of(false));
        return new Line(points);
    }

    public int move(int position) {
        if (position < points.size() && points.get(position).isConnected()) {
            return position + 1;
        }
        if (position > 0 && points.get(position - 1).isConnected()) {
            return position - 1;
        }
        return position;
    }

    public List<Point> getPoints() {
        return points;
    }
}
