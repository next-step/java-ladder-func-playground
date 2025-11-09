package io.suhan.ladder.model;

import java.util.Collections;
import java.util.List;

public record GameConfiguration(List<Participant> participants, List<Outcome> outcomes, int width, int height) {
    @Override
    public List<Participant> participants() {
        return Collections.unmodifiableList(participants);
    }

    @Override
    public List<Outcome> outcomes() {
        return Collections.unmodifiableList(outcomes);
    }
}
