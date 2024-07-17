package model;

import java.util.List;

public class Players {

    private final List<String> playerNames;

    public Players(List<String> playerNames) {
        if (playerNames.stream().distinct().count() != playerNames.size()) {
            throw new IllegalArgumentException("중복된 플레이어 이름이 존재합니다.");
        }
        if (playerNames.contains("all")) {
            throw new IllegalArgumentException("플레이어 이름은 all이 될 수 없습니다.");
        }
        this.playerNames = playerNames;
    }

    public Integer getPlayerCount() {
        return playerNames.size();
    }

    public Integer getPlayerIndexByName(String playerName) {
        Integer index = playerNames.indexOf(playerName);
        if (index == -1) {
            throw new IllegalArgumentException("해당 플레이어는 게임에 참여하지 않은 플레이어입니다.");
        }
        return index;
    }

    public String getPlayerNameByIndex(int index) {
        if (index < 0 || index >= playerNames.size()) {
            throw new IndexOutOfBoundsException("유효하지 않은 플레이어 인덱스입니다.");
        }
        return playerNames.get(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String playerName : playerNames) {
            stringBuilder.append(playerName);
            stringBuilder.append("\t");
        }
        return stringBuilder.toString();
    }
}
