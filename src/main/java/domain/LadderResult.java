package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    private final List<Integer> results;

    public LadderResult(Ladder ladder) {
        this.results = generate(ladder);
    }

    private List<Integer> generate(Ladder ladder) {
        int width = ladder.getWidth();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            resultList.add(ladder.move(i));
        }
        return resultList;
    }

    public List<Integer> getResults() {
        return new ArrayList<>(results);
    }
}
