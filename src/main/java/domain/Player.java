package domain;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 넘어갈 수 없습니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름에 공백이 들어왔습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
