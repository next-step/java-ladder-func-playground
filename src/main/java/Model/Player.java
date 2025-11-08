package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    List<String> players;

    public Player(List<String> players) {
        this.players = players;
    }

    public List<String> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getPlayersNumber() {
        return players.size();
    }

    public String getPlayerName(int index) {
        return players.get(index);
    }

    public int getPlayerIndex(String name) {
        return players.indexOf(name);
    }
}
