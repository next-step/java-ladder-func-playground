package domain;

public class Result {
    private final String value;

    public Result(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Result)) return false;
        return value.equals(((Result) obj).value);
    }

    public int hashCode() {
        return value.hashCode();
    }
}
