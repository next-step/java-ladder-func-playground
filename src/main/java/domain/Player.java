package domain;

public record Player(String name, int position) {
    private static final int MAX_NAME_LENGTH = 5;

    public Player {
        validateName(name);
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("플레이어 이름이 입력되지 않았습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("플레이어 이름은 " + MAX_NAME_LENGTH + "글자 이하입니다.");
        }
    }
}
