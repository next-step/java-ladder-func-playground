package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record Line(List<Boolean> points) {

    public static Line of(List<Integer> indexes, int size) {
        List<Boolean> points = new ArrayList<>(Collections.nCopies(size, Boolean.FALSE));
        indexes.forEach(index -> points.set(index, Boolean.TRUE));

        return new Line(points);
    }

    public int move(int position) {
        if (position < points.size() && points.get(position)) {
            return position + 1;
        }
        if (position > 0 && points.get(position - 1)) {
            return position - 1;
        }
        return position;
    }
}
