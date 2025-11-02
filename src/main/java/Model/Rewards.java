package Model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Rewards {
    private final Map<String, String> playerRewards;

    public Rewards(Player players, List<String> rewards) {
        this.playerRewards = new LinkedHashMap<>();
        List<String> playerNames = players.getPlayers();
        for (String playerName : playerNames) {
            int destinationIndex = players.getDestinatioinPos(playerName);
            String reward = rewards.get(destinationIndex);
            playerRewards.put(playerName, reward);
        }
    }

    public String getRewardForPlayer(String playerName) {
        return playerRewards.get(playerName);
    }

    public Map<String, String> getAllRewards() {
        return Collections.unmodifiableMap(playerRewards);
    }
}