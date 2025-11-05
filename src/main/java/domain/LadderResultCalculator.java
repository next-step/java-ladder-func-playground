package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderResultCalculator {

    public int changeRowLocation(int colIndex, LinePoints linePoints) {
        return linePoints.moveFrom(colIndex);
    }

    public int getFinalColumnIndex(int startColIndex, Ladder ladder) {
        int currentColIndex = startColIndex;
        for (LinePoints linePoints : ladder.getLines()) {
            currentColIndex = changeRowLocation(currentColIndex, linePoints);
        }
        return currentColIndex;
    }

    public Map<String, String> calculateResults(Ladder ladder, List<String> players, List<String> prizes) {
        Map<String, String> resultMap = new LinkedHashMap<>();
        int cols = ladder.getCols();
        if (players.size() != cols || prizes.size() != cols) {
            throw new IllegalArgumentException("플레이어 수와 결과 수는 사다리 너비(cols)와 같아야 합니다.");
        }

        for (int start = 0; start < ladder.getCols(); start++) {
            int end = getFinalColumnIndex(start, ladder);
            resultMap.put(players.get(start), prizes.get(end));
        }

        return resultMap;
    }
}
