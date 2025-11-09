package io.suhan.ladder.model;

import java.util.Collections;
import java.util.Map;

public record GameResult(Map<Participant, Outcome> results) {
    @Override
    public Map<Participant, Outcome> results() {
        return Collections.unmodifiableMap(results);
    }

    public Outcome getOutcome(Participant participant) {
        return results.get(participant);
    }
}
