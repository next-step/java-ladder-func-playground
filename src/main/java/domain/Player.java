package domain;

public record Player(String name, int position) {
    public Player {
        validateName(name);
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("플레이어 이름이 입력되지 않았습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("플레이어 이름은 5글자 이하입니다.");
        }
    }
}
