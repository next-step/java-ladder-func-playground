package ladder.model;

import java.util.Objects;

public class Name {

    private static final int MAX_LENGTH = 5;
    private final String value;

    public Name(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다.");
        }
        this.value = value;
    }

    public boolean matches(String other) {
        return value.equals(other);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
