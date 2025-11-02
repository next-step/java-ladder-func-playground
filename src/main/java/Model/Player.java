package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    List<String> players;
    List<Integer> destinatioinPos = new ArrayList<>();

    public Player(List<String> players) {
        this.players = players;
    }

    public List<String> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public int getDestinatioinPos(String string) {
        return destinatioinPos.get(players.indexOf(string));
    }

    public int getPlayersNumber() {
        return players.size();
    }

    public void playerOnDestination(Bridge bridge) {
        LadderDescentService descentService = new LadderDescentService(bridge);

        for (String player : players) {
            destinatioinPos.add(descentService.descent(players.indexOf(player)));
        }
    }
}
