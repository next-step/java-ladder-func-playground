package model;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Result {
    private final Map<String, String> result;

    private Result(Map<String, String> result) {
        this.result = result;
    }

    public int size() {
        return result.size();
    }

    public Set<String> keys() {
        return result.keySet();
    }

    public String get(String name) {
        return result.get(name);
    }

    public static Result of(Players players, List<String> choices) {
        Map<String, String> result = players.stream()
            .collect(Collectors.toMap(
                Player::getName,
                player -> choices.get(player.getX())
            ));

        return new Result(result);
    }
}
