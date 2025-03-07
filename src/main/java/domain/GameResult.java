package domain;

import java.util.List;

public class GameResult {
    private final List<Result> results;

    public GameResult(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public Result getResultByPlayerName(String name) {
        for (Result result : results) {
            if (result.getPlayerName().equals(name)) {
                return result;
            }
        }
        throw new IllegalArgumentException("해당 이름이 없습니다.");
    }
}
