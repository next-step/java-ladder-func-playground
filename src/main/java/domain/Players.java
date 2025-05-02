package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private Players(List<String> names) {
        this.players = names.stream()
                .map(Player::create)
                .collect(Collectors.toList());
    }

    public static Players from(List<String> names) {
        validate(names);
        return new Players(names);
    }

    public int size() {
        return players.size();
    }

    public List<String> names() {
        return players.stream()
                .map(Player::name)
                .collect(Collectors.toUnmodifiableList());
    }

    public String nameAt(int index) {
        return players.get(index).name();
    }

    private static void validate(List<String> names) {
        if (names.isEmpty() || names.size() < 2) {
            throw new IllegalArgumentException("플레이어는 두 명 이상이어야 합니다.");
        }
    }
}
