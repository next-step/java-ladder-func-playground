package model.player;

import model.ladder.Ladder;

import java.util.*;

public class Players {

    private final List<Player> players;

    private final static int MIN_PLAYER_COUNT = 2;

    public Players(List<String> playerNames) {
        validatePlayers(playerNames);

        this.players = new ArrayList<>();
        generatePlayers(playerNames);
    }

    private void generatePlayers(List<String> playerNames) {
        for (int index = 0; index < playerNames.size(); index++) {

            PlayerName playerName = new PlayerName(playerNames.get(index));
            Position playerPosition = new Position(index);

            Player player = new Player(playerName,playerPosition);

            this.players.add(player);
        }
    }

    private void validatePlayers(List<String> playerNames) {
        if (playerNames.size() < MIN_PLAYER_COUNT){
            throw new IllegalArgumentException("플레이어는 최소 "+MIN_PLAYER_COUNT+"명 이상이어야 합니다.");
        }

        Set<String> playerNamesSet = new HashSet<>(playerNames);
        if(playerNamesSet.size() != playerNames.size()){
            throw new IllegalArgumentException("중복된 플레이어가 존재합니다.");
        }
    }

    public void climbLadder(Ladder ladder){
        for (Player player : this.getPlayers()) {
            player.climbLadder(ladder);
        }
    }

    public Player findPlayerByPlayerName(String playerName) {
        return players.stream()
                .filter(player -> player.getName().equals(playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾고자 하는 플레이어가 존재하지 않습니다."));
    }

    public int count(){
        return players.size();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }
}
