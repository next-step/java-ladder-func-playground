package model.participant;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private final String playerName;

    public Player(String playerName) {
        validatePlayerName(playerName);
        this.playerName = playerName;
    }

    private void validatePlayerName(String playerName) {
        if (playerName == null || playerName.isEmpty() || playerName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("플레이어의 이름은 %d-%d글자 사이여야합니다.", MIN_NAME_LENGTH, MAX_NAME_LENGTH));
        }
    }

    public String getName() {
        return playerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerName, player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }
}
