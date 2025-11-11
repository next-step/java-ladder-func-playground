package domain;

public class PlayerName {
    private static final int PLAYER_NAME_MAX_LENGTH = 5;
    private final String value;

    public PlayerName(String value) {
        if (value == null) {
            throw new IllegalArgumentException("플레이어 이름은 null일 수 없습니다.");
        }
        String trimmed = value.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("플레이어 이름은 비어있을 수 없습니다.");
        }

        if (trimmed.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("플에이어 이름은 5글자를 넘으면 안됩니다.");
        }
        this.value = trimmed;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PlayerName)) return false;
        PlayerName other = (PlayerName) obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}
