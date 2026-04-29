package model;

import constants.ErrorMessage;

import java.util.List;

public class Player extends LadderEntry {
    public Player(List<String> entries) {
        super(entries);
        this.validatePlayer(entries);
    }

    private void validatePlayer(List<String> entries) {
        validateNoDuplicatePlayerNames(entries);
        validatePlayerNameLength(entries);
    }

    private void validatePlayerNameLength(List<String> entries) {
        entries.stream()
                .filter(name -> name.length() > 5)
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException(ErrorMessage.NAME_LONGER_THAN_LIMIT);
                });
    }

    private void validateNoDuplicatePlayerNames(List<String> entries) {
        int reducedCount = Math.toIntExact(entries.stream().distinct().count());
        if (reducedCount != entries.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAMES);
        }
    }
}
