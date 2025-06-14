package domain.player;

public record Name(
        String value
) {

    static final int MAX_NAME_LENGTH = 5;

    public Name {
        validateEmptyName(value);
        validateNameLength(value);
    }

    private void validateEmptyName(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("플레이어의 이름을 입력해야 합니다.");
        }
    }

    private void validateNameLength(final String value) {
        if (MAX_NAME_LENGTH < value.length()) {
            throw new IllegalArgumentException("플레이어의 이름이 %d를 초과합니다.".formatted(MAX_NAME_LENGTH));
        }
    }
}
