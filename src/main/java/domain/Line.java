package domain;

import utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        this.points = List.copyOf(points);
    }

    public List<Boolean> getPoints() {
        return List.copyOf(points);
    }

    public boolean hasBridgeAt(int index) {
        return points.get(index);
    }

    public Line setBridgeAt(int index) {
        List<Boolean> newPoints = new ArrayList<>(points);
        newPoints.set(index, true);
        return new Line(newPoints);
    }

    public static void applyBridges(List<Boolean> points, Set<Integer> reserved, Line prev, boolean isReserved) {
        IntStream.range(0, points.size()).forEach(i -> {
            boolean shouldAddBridge = (isReserved && reserved.contains(i)) || (!isReserved && RandomUtil.nextBoolean());

            if (shouldAddBridge && isValidBridgePosition(points, prev, i)) {
                points.set(i, true);
            }
        });
    }

    public static void ensureOneBridge(List<Boolean> points, Line prev) {
        if (points.contains(true)) return;

        IntStream.range(0, points.size())
                .filter(i -> isValidBridgePosition(points, prev, i))
                .findFirst()
                .ifPresent(i -> points.set(i, true));
    }

    private static boolean isValidBridgePosition(List<Boolean> points, Line prev, int index) {
        if (prev != null && prev.hasBridgeAt(index)) return false;
        if (index > 0 && points.get(index - 1)) return false;
        if (index < points.size() - 1 && points.get(index + 1)) return false;
        return true;
    }
}
