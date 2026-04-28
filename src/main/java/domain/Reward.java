package domain;
public class Reward {
    private static final int MAX_LENGTH = 5;
    private final String value;

    public Reward(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("결과는 5자를 초과할 수 없습니다.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


