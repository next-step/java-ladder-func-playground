package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player extends SplitMethod {
    List<String> players;
    List<Integer> destinatioinPos = new ArrayList<>();

    public Player(String players) {
        this.players = split(players);
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
