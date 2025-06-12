package ladder.model;

public class Result {

    private final String value;

    public Result(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("결과 값은 비어있을 수 없습니다.");
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return value.equals(result.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
