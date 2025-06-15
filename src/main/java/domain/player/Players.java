package domain.player;

import static java.util.stream.Collectors.toSet;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Players {

    private static final int MIN_PLAYER_SIZE = 2;
    private static final int MAX_PLAYER_SIZE = 24;

    private final List<Player> players;

    private Players(final List<Player> players) {
        validatePlayerSize(players);
        validateDuplicateName(players);
        this.players = players;
    }

    public static Players from(final List<String> names) {
        return new Players(
                names.stream()
                        .map(Name::new)
                        .map(Player::new)
                        .toList()
        );
    }

    private void validatePlayerSize(final List<Player> players) {
        int size = players.size();
        if (size < MIN_PLAYER_SIZE || MAX_PLAYER_SIZE < size) {
            throw new IllegalArgumentException(
                    "플레이어 수는 %s 이상 %s 이하여야 합니다.".formatted(MIN_PLAYER_SIZE, MAX_PLAYER_SIZE));
        }
    }

    private void validateDuplicateName(final List<Player> players) {
        Set<String> distinctNames = uniqueNamesFrom(players);
        validateNameCountEqualsDistinctCount(players.size(), distinctNames.size());
    }

    private Set<String> uniqueNamesFrom(final List<Player> players) {
        return players.stream()
                .map(player -> player.name().value())
                .collect(toSet());
    }

    private void validateNameCountEqualsDistinctCount(final int total, final int distinct) {
        if (total != distinct) {
            throw new IllegalArgumentException("플레이어의 이름은 중복이 아니어야 합니다.");
        }
    }

    public int size() {
        return players.size();
    }

    public String name(final int index) {
        return players.get(index).name().value();
    }

    public List<Player> values() {
        return Collections.unmodifiableList(players);
    }
}
