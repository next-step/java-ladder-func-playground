package domain;

public record Player(String name, int position) {
    public Player {
        validate(name);
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("플레이어 이름이 입력되지 않았습니다.");
        }
    }
}
