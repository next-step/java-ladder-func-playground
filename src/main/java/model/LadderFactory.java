package model;

import controller.LadderController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderFactory {
    private final Random random = new Random();

    public Ladder create(LadderSize size) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < size.height(); i++) {
            lines.add(createLine());
        }
        return new Ladder(lines);
    }

    private Line createLine() {
        int pointsCount = LadderController.WIDTH - 1;
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
