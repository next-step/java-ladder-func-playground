package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointsGenerator {
    private static final Random random = new Random();

    public static List<Point> generatePoints(Size lineSize) {
        List<Point> points = new ArrayList<>();
        for (int i = 1; i < lineSize.getSize(); i++) {
            generatePoint(points);
        }
        return points;
    }

    private static void generatePoint(List<Point> points) {
        if (points.isEmpty()) {
            points.add(new Point(getRandomBoolean()));
            return;
        }
        generateNext(points);
    }

    private static void generateNext(List<Point> points) {
        boolean isConnected = false;
        int lastIndex = points.size() - 1;
        if (!points.get(lastIndex).isConnected()) {
            isConnected = getRandomBoolean();
        }
        points.add(new Point(isConnected));
    }

    private static boolean getRandomBoolean() {
        return random.nextBoolean();
    }

}
