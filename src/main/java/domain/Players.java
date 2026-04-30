package domain;

import java.util.ArrayList;
import java.util.List;

public class Players {
    private static final int START_POSITION = 0;
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public static Players fromPlayers(List<Player> players) {
        return new Players(players);
    }

    public static Players from(List<String> playerNames) {
        validate(playerNames);
        List<Player> players = new ArrayList<>();
        int position = START_POSITION;
        for (String name : playerNames) {
            players.add(new Player(name, position++));
        }
        return new Players(players);
    }

    public int size(){
        return players.size();
    }

    public List<Player> toList(){
        return new ArrayList<>(players);
    }

    public List<String> getPlayerNames(){
        return players.stream()
                .map(Player::name)
                .toList();
    }

    private static void validate(List<String> playerNames) {
        long distinctCount = playerNames.stream().distinct().count();
        if (distinctCount != playerNames.size()) {
            throw new IllegalArgumentException("플레이어 이름은 중복될 수 없습니다.");
        }
    }
}
