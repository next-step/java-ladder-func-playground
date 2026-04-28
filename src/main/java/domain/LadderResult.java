package domain;

import java.util.Collections;
import java.util.Map;

public class LadderResult {
    private final Map<Position, Position> results;

    public LadderResult(Map<Position, Position> results) {
        this.results = results;
    }

    public Map<Position, Position> getResults() {
        return Collections.unmodifiableMap(results);
    }
}