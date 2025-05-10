package domain.user;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PlayerNames {

    private final List<PlayerName> playerNames;

    public PlayerNames(List<PlayerName> playerNames) {
        this.playerNames = List.copyOf(playerNames);
    }

    public PlayerName get(int index) {
        return playerNames.get(index);
    }

    public int size() {
        return playerNames.size();
    }

    public Stream<IndexedPlayerName> streamWithIndex() {
        return IntStream.range(0, playerNames.size())
                .mapToObj(i -> new IndexedPlayerName(i, playerNames.get(i)));
    }

    public record IndexedPlayerName(int index, PlayerName name) {
    }

    public PlayerName getByIndex(int index) {
        return playerNames.get(index);
    }

    public boolean contains(PlayerName name) {
        return playerNames.stream().anyMatch(n -> n.equals(name));
    }

    public List<Integer> toIntegerList() {
        return IntStream.range(0, playerNames.size()).boxed().toList();
    }
}
