package model;

import constants.ErrorMessage;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Players {
    private final List<String> playerNames;

    public Players(List<String> playerNames) {
        this.validatePlayer(playerNames);
        this.playerNames = playerNames;
    }

    private void validatePlayer(List<String> playerNames) {
        validateNoDuplicatePlayerNames(playerNames);
        validatePlayerNameLength(playerNames);
    }

    private void validatePlayerNameLength(List<String> playerNames) {
        playerNames.stream()
                .filter(name -> name.length() > 5)
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException(ErrorMessage.NAME_LONGER_THAN_LIMIT);
                });
    }

    private void validateNoDuplicatePlayerNames(List<String> playerNames) {
        int reducedCount = Math.toIntExact(playerNames.stream().distinct().count());
        if (reducedCount != playerNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAMES);
        }
    }

    public Integer calculateIndexOfPlayerName(String playerName) {
        return IntStream.range(0, this.playerNames.size())
                .filter(i-> Objects.equals(this.playerNames.get(i), playerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ENTRY_NOT_PRESENT));
    }

    public String getEntryByIndex(int index) {
        return this.playerNames.get(index);
    }

    public Integer entryCount() {
        return this.playerNames.size();
    }
}
