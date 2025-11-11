package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Results results;

    public LadderGame(Ladder ladder, Players players, Results results) {
        this.ladder = ladder;
        this.players = players;
        this.results = results;
    }

    public static void validatePlayerAndResultCount(Players players, Results results) {
        if (players.size() != results.size()) {
            throw new IllegalArgumentException("참가자와 결과 수는 같아야 합니다.");
        }
    }

    private int move(int position) {
        for (Line line : ladder.getLines()) {
            position = line.moveOf(position);
        }
        return position;
    }


    public String findResultByPlayer(String name) {
        List<PlayerName> player = players.getPlayers();
        List<ResultName> result = results.getResults();

        int index = player.indexOf(new PlayerName(name));
        if (index < 0) {
            throw new IllegalArgumentException("존재하지 않는 플레이어입니다.");
        }
        index = move(index);
        return result.get(index).value();
    }

    public Map<String, String> findAll() {
        Map<String, String> map = new HashMap<>();
        List<PlayerName> player = players.getPlayers();
        for (PlayerName name : player) {
            map.put(name.value(), findResultByPlayer(name.value()));
        }
        return map;
    }
}
