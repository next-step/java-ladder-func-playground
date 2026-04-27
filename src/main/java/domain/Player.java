package domain;

import java.util.Objects;

public class Player {
    private final String name;

    public Player(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean nameEquals(String name) {
        return equals(new Player(name));
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player player)) return false;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
