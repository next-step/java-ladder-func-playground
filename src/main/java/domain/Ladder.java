package domain;

import java.util.Collections;
import java.util.List;

public record Ladder(
        List<Line> lines
) {

    public Ladder(final List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }
}
