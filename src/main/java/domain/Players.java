package domain;

import static constants.LadderConstants.ALL_PLAYER;
import static constants.LadderConstants.MAX_NAME_LENGTH;

import java.util.List;

import exception.InvalidPlayerNameException;

public class Players {

    private final List<String> names;

    public Players(List<String> names) {
        validatePlayers(names);
        this.names = List.copyOf(names);
    }

    private void validatePlayers(List<String> players) {
        validatePlayerListNotNullOrEmpty(players);
        validateAtLeastTwoPlayers(players);
        for (String name : players) {
            validateNameLength(name);
            validateAllPlayerName(name);
            validateNameNotNullOrEmpty(name);
        }
    }

    private void validateAtLeastTwoPlayers(List<String> players) {
        if (players.size() < 2) {
            throw new InvalidPlayerNameException("플레이어는 최소 2명 이상이어야 합니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new InvalidPlayerNameException("플레이어 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
        }
    }

    private void validateAllPlayerName(String name) {
        if (name.equals(ALL_PLAYER)) {
            throw new InvalidPlayerNameException("플레이어 이름으로 all은 사용할 수 없습니다.");
        }
    }

    private void validatePlayerListNotNullOrEmpty(List<String> players) {
        if (players == null || players.isEmpty()) {
            throw new InvalidPlayerNameException("플레이어 목록은 비어있을 수 없습니다.");
        }
    }

    private void validateNameNotNullOrEmpty(String name) {
        if (name == null || name.isBlank()) {
            throw new InvalidPlayerNameException("플레이어 이름은 null이나 빈 문자열이 될 수 없습니다.");
        }
    }

    public List<String> getNames() {
        return names;
    }
}
