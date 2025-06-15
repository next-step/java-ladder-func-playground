package domain.player;

public record Name(
        String value
) {

    private static final int MAX_NAME_LENGTH = 5;

    public Name {
        validateEmptyName(value);
        validateNameLength(value);
    }

    private void validateEmptyName(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("플레이어의 이름은 공백이 아니어야 합니다.");
        }
    }

    private void validateNameLength(final String value) {
        if (MAX_NAME_LENGTH < value.length()) {
            throw new IllegalArgumentException("플레이어의 이름은 %d자 이하여야 합니다.".formatted(MAX_NAME_LENGTH));
        }
    }
}
