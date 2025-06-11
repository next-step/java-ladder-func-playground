package result;

public record Prize(String value) {
    public Prize {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("실행 결과는 비어 있을 수 없습니다.");
        }
    }

    public static Prize from(String value) {
        return new Prize(value);
    }
}
