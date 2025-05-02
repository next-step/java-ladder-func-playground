package domain;

public class Player {

    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    private Player(String name) {
        this.name = name;
    }

    public static Player create(String name) {
        validate(name);
        return new Player(name);
    }

    public String name() {
        return name;
    }

    private static void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름을 입력해주세요");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다: " + name);
        }
    }
}
