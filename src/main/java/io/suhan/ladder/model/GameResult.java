package io.suhan.ladder.model;

import java.util.Collections;
import java.util.Map;

public class GameResult {
    private final Map<Participant, String> results;

    public GameResult(Map<Participant, String> results) {
        this.results = results;
    }

    public Map<Participant, String> getResults() {
        return Collections.unmodifiableMap(results);
    }

    public String getOutcome(Participant participant) {
        return results.get(participant);
    }
}
