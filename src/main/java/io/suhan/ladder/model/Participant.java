package io.suhan.ladder.model;

public record Participant(String name) {
    public static final int PARTICIPANT_NAME_MAX_LENGTH = 5;

    public Participant {
        if (name.length() > PARTICIPANT_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("참가자의 이름은 최대 " + PARTICIPANT_NAME_MAX_LENGTH + "자만 가능합니다.");
        }
    }
}
