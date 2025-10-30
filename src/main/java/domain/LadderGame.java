package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Results results;

    public LadderGame(Ladder ladder, Players players, Results results) {
        validatePlayerAndResultCount(players, results);
        this.ladder = ladder;
        this.players = players;
        this.results = results;
    }

    private void validatePlayerAndResultCount(Players players, Results results) {
        if (players.size() != results.size()) {
            throw new IllegalArgumentException("참가자와 결과 수는 같아야 합니다.");
        }
    }

    private int move(int position) {
        for (Line line : ladder.getLines()) {
            position += calculateNextPosition(line, position);
        }
        return position;
    }

    private int calculateNextPosition(Line line, int position) {
        if ((line.validateMoveRight(position))) return 1;
        if ((line.validateMoveLeft(position))) return -1;
        return 0;
    }

    public String findResultByPlayer(String name) {
        List<String> player = players.getPlayers().getValues();
        List<String> result = results.getResults().getValues();

        int index = player.indexOf(name);
        index = move(index);
        return result.get(index);
    }

    public Map<String, String> findAll() {
        Map<String, String> map = new HashMap<>();
        List<String> player = players.getPlayers().getValues();
        for (String name : player) {
            map.put(name, findResultByPlayer(name));
        }
        return map;
    }
}
