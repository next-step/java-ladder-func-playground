package model;

import java.util.Objects;
import java.util.Set;

public class LadderUser {

    private static final Set<String> RESERVED_KEYWORD = Set.of("all");
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public LadderUser(String name) {
        validateName(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 비어 있습니다.");
        }
        if (isReservedKeyword(name)) {
            throw new IllegalArgumentException(name + "은 이름으로 사용할 수 없습니다. 사용 불가능한 이름 목록: " + RESERVED_KEYWORD);
        }
        if (isLongerThanMaxLength(name)) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "글자를 넘길 수 없습니다.");
        }
    }

    private boolean isReservedKeyword(String name) {
        return RESERVED_KEYWORD.contains(name);
    }

    private boolean isLongerThanMaxLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderUser that = (LadderUser) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
