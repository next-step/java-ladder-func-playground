package domain;

public class Name {
    private final String value;

    public Name(String value) {
        if (value.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자여야 합니다.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
