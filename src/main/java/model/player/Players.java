package model.player;

import model.tool.Splitter;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private List<Player> playerInventory= new ArrayList<>();

    public Players(String [] playerNames){
        for (int i = 0; i < playerNames.length; i++) {
            Player player = new Player(i, playerNames[i]);
            playerInventory.add(player);
        }
    }

    public List<Player> getPlayerInventory() {
        return playerInventory;
    }
}
