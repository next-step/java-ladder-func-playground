package model;

import java.util.*;
import java.util.stream.*;

public class SingleLineGenerator {
    private static final Random RANDOM = new Random();

    public static Line generate(int width, Set<Integer> reserved) {
        List<Boolean> points = new ArrayList<>(Collections.nCopies(width, false));

        reserved.forEach(i -> points.set(i, true));
        System.out.println(points);
        IntStream.range(0, width).forEach(i -> {
            if (!points.get(i) && isNotOverlap(points, i)) {
                points.set(i, RANDOM.nextBoolean());
            }
        });

        return new Line(points);
    }

    private static boolean isNotOverlap(List<Boolean> points, int i) {
        if (i < points.size() -1 && points.get(i+1)) return false;
        if (i > 0 && points.get(i - 1)) return false;
        return true;
    }
}
