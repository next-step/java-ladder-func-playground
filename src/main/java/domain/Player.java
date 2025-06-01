package domain;

import java.util.Set;

public record Player(String name) {
    private static final int MAX_NAME_LENGTH = 5;
    private static final Set<String> INVALID_NAMES = Set.of("all");

    public Player {
        validate(name);
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 넘어갈 수 없습니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름에 공백이 들어왔습니다.");
        }
        if (INVALID_NAMES.contains(name)){
            throw new IllegalArgumentException("해당 이름은 사용할 수 없습니다:" + name);
        }
    }
}
