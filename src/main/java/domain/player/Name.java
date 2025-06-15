package domain.player;

import static constants.ReservedWord.FINISH_KEYWORD;

public record Name(
        String value
) {

    private static final int MAX_NAME_LENGTH = 5;

    public Name {
        validateEmptyName(value);
        validateNameLength(value);
        validateInvalidName(value);
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

    private void validateInvalidName(final String value) {
        if (value.equals(FINISH_KEYWORD)) {
            throw new IllegalArgumentException("'%s'은 예약어이므로 플레이어의 이름이 아니어야 합니다.".formatted(FINISH_KEYWORD));
        }
    }
}
