package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Players {
    private final List<Player> players;

    private Players(List<Player> players) {
        this.players = new ArrayList<>(players);
    }

    public static Players of(String[] playerNames){
        validate(playerNames);
        List<Player> players = new ArrayList<>();
        int position = 0;
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
        return new ArrayList<>(players).stream()
                .map(Player::name)
                .toList();
    }

    private static void validate(String[] playerNames) {
        long distinctCount = Arrays.stream(playerNames).distinct().count();
        if (distinctCount != playerNames.length) {
            throw new IllegalArgumentException("플레이어 이름은 중복될 수 없습니다.");
        }
    }
}
