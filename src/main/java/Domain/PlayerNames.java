package Domain;

import java.util.List;
import java.util.stream.IntStream;

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

    public List<PlayerName> getAll() {
        return playerNames;
    }

    public boolean contains(PlayerName name) {
        return playerNames.stream().anyMatch(n -> n.equals(name));
    }

    public List<Integer> toIntegerList() {
        return IntStream.range(0, playerNames.size()).boxed().toList();
    }
}
