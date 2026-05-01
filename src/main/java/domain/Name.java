package domain;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하여야 합니다.");
        }
        this.name = name.trim(); //앞뒤 공백 제거해서 저장 (의도한 값만 남긴다)
    }

    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        return Objects.equals(name, ((Name) o).name); //내부 문자열이 같으면 같은 객체로 판단하게 한다
    }

    @Override
    public int hashCode() { return Objects.hash(name); }
}
