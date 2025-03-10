package utils.generator;

import domain.Line;
import java.util.*;
import java.util.stream.IntStream;

public class SingleLineGenerator {
    private static final Random RANDOM = new Random();

    public static Line generate(int width, Set<Integer> reserved, Line prev) {
        List<Boolean> points = new ArrayList<>(Collections.nCopies(width, false));

        reserved.forEach(i -> {
            if (isNotOverlap(points, prev, i)) {
                points.set(i, true);
            }
        });

        IntStream.range(0, width).forEach(i -> {
            if (!points.get(i) && isNotOverlap(points, prev, i)) {
                points.set(i, RANDOM.nextBoolean());
            }
        });

        ensureOneBridge(points, prev);
        return new Line(points);
    }

    private static boolean isNotOverlap(List<Boolean> points, Line prev, int i) {
        if (prev != null && prev.hasBridgeAt(i)) return false;
        if (i > 0 && points.get(i - 1)) return false;
        return true;
    }

    private static void ensureOneBridge(List<Boolean> points, Line prev) {
        if (points.contains(true)) return;

        IntStream.range(0, points.size())
                .filter(i -> canSetBridge(points, prev, i))
                .findFirst()
                .ifPresent(i -> points.set(i, true));
    }

    private static boolean canSetBridge(List<Boolean> points, Line prev, int index) {
        return (prev == null || !prev.hasBridgeAt(index))
                && (index == 0 || !points.get(index - 1));
    }
}
