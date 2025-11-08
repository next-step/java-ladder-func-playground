package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {
    private final List<String> players;

    public Players(List<String> rawPlayers) {
        validateRawPlayers(rawPlayers);

        List<String> players = new ArrayList<>(rawPlayers.size());
        for (String raw : rawPlayers) {
            String name = raw == null ? "" : raw.trim();
            validateName(name);
            players.add(name);
        }
        this.players = players;
    }

    private void validateRawPlayers(List<String> rawPlayers) {
        if (rawPlayers == null) {
            throw new IllegalArgumentException("플레이어 목록이 null 입니다.");
        }
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("플레이어 이름이 비어 있습니다.");
        }
    }

    public int size() {
        return players.size();
    }

    public String get(int index) {
        return players.get(index);
    }

    public List<String> asList() {
        return Collections.unmodifiableList(players);
    }
}
