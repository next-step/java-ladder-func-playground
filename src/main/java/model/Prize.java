package model;

import constants.ErrorMessage;

import java.util.List;

public class Prize extends LadderEntry{
    public Prize(List<String> entries) {
        super(entries);
        this.validatePlayer(entries);
    }

    private void validatePlayer(List<String> entries) {
        validateEntryLength(entries);
    }

    private void validateEntryLength(List<String> entries) {
        entries.stream().
        filter(name -> name.length() > 5).
        findAny().
        ifPresent(name -> {throw new IllegalArgumentException(ErrorMessage.NAME_LONGER_THAN_LIMIT);});
    }
}
