package model;

import java.util.List;
import java.util.Map;

public enum Point {
    HAS_POINT(true),
    NO_POINT(false);

    private final boolean point;

    Point(boolean point) {
        this.point = point;
    }

    public static String toStringUsingMap(List<Point> points) {
        Map<Point, String> pointToStringMap = Map.of(
                HAS_POINT, "HAS_POINT",
                NO_POINT, "NO_POINT"
        );

        return points.stream()
                .map(point -> pointToStringMap.getOrDefault(point, "UNKNOWN"))
                .toList().toString();
    }
}
