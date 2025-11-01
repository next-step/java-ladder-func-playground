package io.suhan.ladder.model;

import java.util.Collections;
import java.util.List;

public record GameConfiguration(List<Participant> participants, List<String> outcomes, int width, int height) {
    @Override
    public List<Participant> participants() {
        return Collections.unmodifiableList(participants);
    }

    @Override
    public List<String> outcomes() {
        return Collections.unmodifiableList(outcomes);
    }
}
