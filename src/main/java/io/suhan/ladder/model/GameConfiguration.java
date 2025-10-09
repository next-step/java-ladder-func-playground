package io.suhan.ladder.model;

import java.util.Collections;
import java.util.List;

public class GameConfiguration {
    private final List<Participant> participants;
    private final List<String> outcomes;
    private final int width;
    private final int height;

    public GameConfiguration(List<Participant> participants, List<String> outcomes, int width, int height) {
        this.participants = participants;
        this.outcomes = outcomes;
        this.width = width;
        this.height = height;
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public List<String> getOutcomes() {
        return Collections.unmodifiableList(outcomes);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
