package domain;

public class Name {
    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }
        if (value.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
        }
        if (value.equals("all")) {
            throw new IllegalArgumentException("\"all\"은 참가자 이름으로 사용할 수 없습니다.");
        }
    }

    public String getValue() {
        return value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Name)) return false;
        return value.equals(((Name) obj).value);
    }

    public int hashCode() {
        return value.hashCode();
    }
}
