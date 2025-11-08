package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prizes {
    private final List<String> prizes;

    public Prizes(List<String> rawPrizes) {
        validateRawPrizes(rawPrizes);

        List<String> prizes = new ArrayList<>(rawPrizes.size());
        for (String raw : rawPrizes) {
            String value = raw == null ? "" : raw.trim();
            validateValue(value);
            prizes.add(value);
        }
        this.prizes = prizes;
    }

    private void validateRawPrizes(List<String> rawPrizes) {
        if (rawPrizes == null) {
            throw new IllegalArgumentException("결과 목록이 null 입니다.");
        }
    }

    private void validateValue(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("결과가 비어 있습니다.");
        }
    }

    public int size() {
        return prizes.size();
    }

    public String get(int index) {
        return prizes.get(index);
    }

    public List<String> asList() {
        return Collections.unmodifiableList(prizes);
    }
}
