package controller.command;

import java.util.Set;

public final class QueryCommand {

    public static final String QUIT = "q";
    public static final String ALL = "all";
    public static final Set<String> FORBIDDEN_PLAYER_NAMES = Set.of(QUIT, ALL);

    private QueryCommand() {
    }
}
