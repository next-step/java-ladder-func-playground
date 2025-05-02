package Domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Players {

    private final List<PlayerName> playerNames;

    public Players(List<PlayerName> playerNames) {
        this.playerNames = List.copyOf(playerNames);
    }

    public PlayerName get(int index) {
        return playerNames.get(index);
    }

    public int size() {
        return playerNames.size();
    }

    public int indexOf(PlayerName name) {
        return IntStream.range(0, playerNames.size())
                .filter(i -> playerNames.get(i).equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름 없음"));
    }

    public List<PlayerName> getAll() {
        return Collections.unmodifiableList(playerNames);
    }

    public boolean contains(PlayerName name) {
        return playerNames.stream().anyMatch(n -> n.equals(name));
    }
}
