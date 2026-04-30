package domain;

public enum ResultType {
    ALL("all"),
    SINGLE(null);

    private final String command;

    ResultType(String command) {
        this.command = command;
    }

    public static ResultType from(String input) {
        if (ALL.matches(input)) {
            return ALL;
        }
        return SINGLE;
    }

    private boolean matches(String input) {
        return command != null && command.equalsIgnoreCase(input);
    }

    public boolean isAll() {
        return this == ALL;
    }
}
