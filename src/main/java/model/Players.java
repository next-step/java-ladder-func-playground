package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = players;
    }

    public Stream<Player> stream() {
        return players.stream();
    }

    public int size() {
        return players.size();
    }

    public void move(Ladder ladder) {
        for (Player player : players) {
            player.move(ladder);
        }
    }

    public static Players from(List<String> names) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            players.add(Player.of(names.get(i), i, 0));
        }

        return new Players(players);
    }
}
