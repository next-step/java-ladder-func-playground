package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.BooleanSupplier;

public class Lines implements Iterable<Line> {
    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int participantCount, LadderHeight height, BooleanSupplier strategy) {
        List<Line> lines = new ArrayList<>();
        int pointCount = participantCount - 1;
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(Line.from(pointCount, strategy));
        }
        return new Lines(lines);
    }

    public int move(int startIndex) {
        int currentIndex = startIndex;
        for (Line line : lines) {
            currentIndex = line.move(currentIndex);
        }
        return currentIndex;
    }

    public List<Line> getValues() {
        return Collections.unmodifiableList(lines);
    }

    public Line get(int index) {
        return lines.get(index);
    }

    public int size() {
        return lines.size();
    }

    @Override
    public Iterator<Line> iterator() {
        return lines.iterator();
    }
}
