package Domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = List.copyOf(players);
    }

    public Player get(int index) {
        return players.get(index);
    }

    public int size() {
        return players.size();
    }

    public int indexOf(Name name) {
        return IntStream.range(0, players.size())
                .filter(i -> players.get(i).getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름 없음"));
    }

    public List<Player> getAll() {
        return Collections.unmodifiableList(players);
    }

    public boolean contains(Name name) {
        return players.stream().anyMatch(player -> player.getName().equals(name));
    }
}
