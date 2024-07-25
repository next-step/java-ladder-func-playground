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

    public void move(Ladder ladder) {
        for (Player player : players) {
            player.move(ladder);
        }
    }

    public static Players from(int size) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            players.add(Player.of(i, i, 0));
        }

        return new Players(players);
    }
}
