package ladder.model;

public enum ResultType {
    ALL("all"),
    SINGLE("");

    private final String value;

    ResultType(String value) {
        this.value = value;
    }

    public static ResultType from(String input) {
        return "all".equals(input) ? ALL : SINGLE;
    }
}
