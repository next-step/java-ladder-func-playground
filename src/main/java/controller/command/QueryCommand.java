package controller.command;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

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
            Arrays.stream(QueryCommand.values())
                    .map(QueryCommand::value)
                    .collect(Collectors.toUnmodifiableSet());
}
