package domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private final Names players;

    public Players(String input) {
        this.players = removeDuplicate(input);
        validatePlayerNames();
    }

    private Names removeDuplicate(String input) {
        String[] tokens = input.split(",");
        List<Name> newInput = new ArrayList<>();

        for (String token : tokens) {
            String trimmed = token.trim();
            if (!trimmed.isEmpty()) {
                Name name = new Name(trimmed);
                if (!newInput.contains(name)) {
                    newInput.add(name);
                }
            }
        }
        return new Names(newInput);
    }

    private void validatePlayerNames() {
        for (Name name : players.getValues()) {
            validateNameLength(name);
        }
    }

    private void validateNameLength(Name name) {
        if (name.value().length() > 5) {
            throw new IllegalArgumentException("이름은 5글자를 넘기면 안됩니다.");
        }
    }

    public int size() {
        return players.size();
    }

    public Names getPlayers() {
        return players;
    }
}
