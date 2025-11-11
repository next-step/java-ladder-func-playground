package domain;

public class ResultName {
    private final String value;

    public ResultName(String value) {
        if (value == null) {
            throw new IllegalArgumentException("결과 이름은 null일 수 없습니다.");
        }
        String trimmed = value.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("결과 이름은 비어있을 수 없습니다.");
        }

        this.value = trimmed;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ResultName)) return false;
        ResultName other = (ResultName) obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}
