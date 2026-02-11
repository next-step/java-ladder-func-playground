package ladder.domain;

public class Name {

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name from(String name) {
        String trimmedName = name.trim();
        validate(trimmedName);
        return new Name(trimmedName);
    }

    public String getName() {
        return name;
    }

    private static void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 값일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자입니다.");
        }
    }
}
