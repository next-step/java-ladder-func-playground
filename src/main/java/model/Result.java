package model;

import java.util.Map;
import java.util.stream.Collectors;

public class Result {
    private Map<String, String> result;

    private Result(Map<String, String> result) {
        this.result = result;
    }

    public int size() {
        return result.size();
    }

    public String get(String name) {
        return result.get(name);
    }

    public static Result from(Players players) {
        Map<String, String> result = players.stream()
            .collect(Collectors.toMap(
                Player::getName,
                player -> String.valueOf(player.getX())
            ));

        return new Result(result);
    }
}
