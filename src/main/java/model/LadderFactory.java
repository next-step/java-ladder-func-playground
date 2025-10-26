package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderFactory {
    private final Random random = new Random();

    public Ladder create(LadderSize size) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < size.width(); i++) {
            lines.add(createLine(size.height()));
        }
        return new Ladder(lines);
    }

    private Line createLine(int width) {
        int pointsCount = width - 1;
        List<Point> points = new ArrayList<>();
        boolean prevConnected = false;
        for (int i = 0; i < pointsCount; i++) {
            boolean connect = false;
            if (!prevConnected) {
                connect = random.nextBoolean();
            }
            points.add(new Point(connect));
            prevConnected = connect;
        }
        return new Line(points);
    }
}
