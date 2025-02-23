package domain;

public class Player {
    private final String name;
    private static final int MAX_NAME_LENGTH = 5;

    public Player(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("플레이어 이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) { // 길이 검사
            throw new IllegalArgumentException("플레이어 이름은 5자를 초과할 수 없습니다. : " + name);
        }
        // 추가적인 이름 유효성 검사 (예: 길이 제한)
        this.name = name;
    }

    public String getName() {
        return name;
    }
}