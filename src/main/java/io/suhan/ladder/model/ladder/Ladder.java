package io.suhan.ladder.model.ladder;

import java.util.Collections;
import java.util.List;

public record Ladder(List<Line> lines) {
    @Override
    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }
}
