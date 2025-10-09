package io.suhan.ladder.model;

import java.util.Collections;
import java.util.List;

public class GameConfiguration {
    private List<Participant> participants;
    private List<String> outcomes;
    private int width;
    private int height;

    private GameConfiguration(List<Participant> participants, List<String> outcomes, int width, int height) {
        this.participants = participants;
        this.outcomes = outcomes;
        this.width = width;
        this.height = height;
    }

    public static GameConfiguration of(List<Participant> participants, List<String> outcomes, int height) {
        int width = participants.size();
        validateParams(participants, outcomes, width, height);

        return new GameConfiguration(participants, outcomes, width, height);
    }

    private static void validateParams(List<Participant> participants, List<String> outcomes, int width, int height) {
        if (participants.size() != outcomes.size()) {
            throw new IllegalArgumentException("참가자의 수와 실행 결과의 수는 같아야 합니다.");
        }

        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("크기는 양수만 입력할 수 있습니다.");
        }
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
