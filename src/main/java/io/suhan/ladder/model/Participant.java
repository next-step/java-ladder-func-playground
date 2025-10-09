package io.suhan.ladder.model;

public class Participant {
    public static final int PARTICIPANT_NAME_MAX_LENGTH = 5;
    private final String name;

    public Participant(String name) {
        if (name.length() > PARTICIPANT_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("참가자의 이름은 최대 " + PARTICIPANT_NAME_MAX_LENGTH + "자만 가능합니다.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
