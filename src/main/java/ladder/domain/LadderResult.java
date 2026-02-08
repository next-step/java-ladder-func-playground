package ladder.domain;

public class LadderResult {
    private final String value;

    private LadderResult(String value) {
        validate(value);
        this.value = value;
    }

    public static LadderResult from(String value) {
        return new LadderResult(value.trim());
    }

    public String getValue() {
        return value;
    }

    private void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("실행 결과는 빈 값일 수 없습니다.");
        }
        if (value.length() > 5) {
            throw new IllegalArgumentException("실행 결과는 최대 5글자입니다.");
        }
    }
}
