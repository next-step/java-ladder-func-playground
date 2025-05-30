package domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private final Names names;
    private final Results results;
    private final Ladder ladder;

    public LadderGame(Names names, Results results, Ladder ladder) {
        this.names = names;
        this.results = results;
        this.ladder = ladder;
    }

    public Result play(Name name) {
        int index = names.indexOf(name);
        if (index == -1) {
            throw new IllegalArgumentException("존재하지 않는 참가자입니다: " + name.getValue());
        }
        int resultIndex = ladder.traverse(index);
        return results.get(resultIndex);
    }

    public Map<Name, Result> playAll() {
        return names.getValues().stream()
                .collect(Collectors.toMap(n -> n, this::play));
    }

    public Ladder getLadder() {
        return ladder;
    }
}
