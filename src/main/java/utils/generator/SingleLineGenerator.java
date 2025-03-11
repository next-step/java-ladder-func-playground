package utils.generator;

import domain.Line;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SingleLineGenerator {
    public static Line generate(int width, Set<Integer> reserved, Line prev) {
        List<Boolean> points = new ArrayList<>(Collections.nCopies(width, false));

        Line.applyBridges(points, reserved, prev, true);
        Line.applyBridges(points, null, prev, false);
        Line.ensureOneBridge(points, prev);

        return new Line(points);
    }

}
