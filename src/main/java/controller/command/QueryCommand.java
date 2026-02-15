package controller.command;

import java.util.Set;

public enum QueryCommand {

    QUIT("q"),
    ALL("all");

    private final String value;

    QueryCommand(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static final Set<String> FORBIDDEN_PLAYER_NAMES =
            Set.of(QUIT.value, ALL.value);
}
