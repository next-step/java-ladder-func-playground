package domain;

import java.util.Objects;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validateInput(name);
        this.name = name;
    }

    private void validateInput(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("참여할 사람의 이름은 1자 이상 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
