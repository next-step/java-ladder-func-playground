package model.player;

public class PlayerResultDto {
    private String playerName;
    private String playerResult;

    public PlayerResultDto(String playerName, String playerResult) {
        this.playerName = playerName;
        this.playerResult = playerResult;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerResult() {
        return playerResult;
    }
}
