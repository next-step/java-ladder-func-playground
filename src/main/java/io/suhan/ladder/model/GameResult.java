package io.suhan.ladder.model;

import java.util.Collections;
import java.util.Map;

public record GameResult(Map<Participant, String> results) {
    @Override
    public Map<Participant, String> results() {
        return Collections.unmodifiableMap(results);
    }

    public String getOutcome(Participant participant) {
        return results.get(participant);
    }
}
