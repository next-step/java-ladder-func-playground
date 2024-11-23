package model.player;

import java.util.List;
import java.util.Map;

public class PlayerResults {
    private List<PlayerResultDto> PlayerResultsInventory;

    public PlayerResults(List<PlayerResultDto> playerResultsInventory) {
        PlayerResultsInventory = playerResultsInventory;
    }

    public String getPlayerResult(String playerName) {
        String result = null;
        for (PlayerResultDto playerResultDto : PlayerResultsInventory) {
            if (playerName.equals(playerResultDto.getPlayerName())) result = playerResultDto.getPlayerResult();
        }
        return result;
    }

    public List<PlayerResultDto> getPlayerResultsInventory() {
        return PlayerResultsInventory;
    }
}
