package domain;

public class PlayerName {
    private static final int MAX_LENGTH = 5;
    private final String value;

    public PlayerName(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
