package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineGenerator {
    private final static Random random = new Random();

    public static List<Boolean> makeLine(int width) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            boolean value;
            if (i > 0 && points.get(i - 1)) {
                value = false;
            } else {
                value = random.nextBoolean();
            }
            points.add(value);
        }
        return points;
    }
}
