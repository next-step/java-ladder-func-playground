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

        for (int start = 0; start < ladder.getCols(); start++) {
            int end = getFinalColumnIndex(start, ladder);
            resultMap.put(players.get(start), prizes.get(end));
        }

        return resultMap;
    }

}
