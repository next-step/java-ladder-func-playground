package ladder.model;

public class Name {

    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다.");
        }
        this.name = name;
    }

    public boolean matches(String other) {
        return name.equals(other);
    }
}
