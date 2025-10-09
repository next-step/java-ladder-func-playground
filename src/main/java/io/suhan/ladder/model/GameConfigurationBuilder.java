package io.suhan.ladder.model;

import java.util.List;

public class GameConfigurationBuilder {
    private List<Participant> participants;
    private List<String> outcomes;
    private int height;

    public GameConfigurationBuilder participants(List<Participant> participants) {
        if (participants == null || participants.isEmpty()) {
            throw new IllegalArgumentException("참가자 목록은 비어 있을 수 없습니다.");
        }

        this.participants = participants;

        return this;
    }

    public GameConfigurationBuilder outcomes(List<String> outcomes) {
        if (outcomes == null || outcomes.size() != participants.size()) {
            throw new IllegalArgumentException("참가자의 수와 실행 결과의 수는 같아야 합니다.");
        }

        this.outcomes = outcomes;

        return this;
    }

    public GameConfigurationBuilder height(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("높이는 양수여야 합니다.");
        }

        this.height = height;

        return this;
    }

    public GameConfiguration build() {
        return new GameConfiguration(participants, outcomes, participants.size(), height);
    }
}
