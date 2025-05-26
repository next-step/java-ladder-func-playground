package domain;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    public static final String ERROR_EMPTY_NAME = "이름을 입력하세요.";
    public static final String ERROR_LENGTH = "이름은 " + MAX_NAME_LENGTH + "글자를 넘을 수 없습니다.";
    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
