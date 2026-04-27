package model;

import constants.ErrorMessage;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

class LadderEntry {
    private final List<String> entries;

    public LadderEntry(List<String> entries) {
        this.entries = entries;
    }

    public Integer calculateIndexOfEntry(String entry) {
        return IntStream.range(0, entries.size())
                .filter(i-> Objects.equals(entries.get(i), entry))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ENTRY_NOT_PRESENT));
    }
}
