package domain.prize;

public class PrizeName {

    private static final int MAX_LENGTH = 5;
    private final String value;

    public PrizeName(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("결과는 비어 있을 수 없습니다.");
        }
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("결과는 " + MAX_LENGTH + "자를 초과할 수 없습니다.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
