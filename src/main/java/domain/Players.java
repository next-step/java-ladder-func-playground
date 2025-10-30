package domain;

public class Players {
    private final Names players;

    public Players(String input) {
        this.players = new Names(input);
        validatePlayerNames();
    }

    private void validatePlayerNames() {
        for (String name : players.getValues()) {
            validateNameLength(name);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
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
