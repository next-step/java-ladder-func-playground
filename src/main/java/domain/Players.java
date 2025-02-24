package domain;

import java.util.List;

import exception.InvalidPlayerNameException;

public class Players {

    private static final int MAX_NAME_LENGTH = 5;
    private final List<String> names;

    public Players(List<String> names) {
        validatePlayers(names);
        this.names = List.copyOf(names);
    }

    private void validatePlayers(List<String> players) {
        validatePlayerListNotNullOrEmpty(players);
        for (String name : players) {
            validateNameNotNullOrEmpty(name);
            validateNameLength(name);
        }
    }

    private void validatePlayerListNotNullOrEmpty(List<String> players) {
        if (players == null || players.isEmpty()) {
            throw new InvalidPlayerNameException("플레이어 목록은 비어있을 수 없습니다.");
        }
    }

    private void validateNameNotNullOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidPlayerNameException("플레이어 이름은 null이나 빈 문자열이 될 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InvalidPlayerNameException("플레이어 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
        }
    }

    public List<String> getNames() {
        return names;
    }
}
