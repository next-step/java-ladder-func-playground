package model;

import java.util.List;

public class Players {
    private final List<Player> playersList;

    public Players(List<Player> playersList) {
        this.playersList = playersList;
    }

    public int size(){
        return playersList.size();
    }

    public List<Player> getPlayersList() {
        return playersList;
    }
}
