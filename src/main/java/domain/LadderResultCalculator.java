package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderResultCalculator {

    public int changeRowLocation(int colIndex, LinePoints linePoints) {
        List<Boolean> points = linePoints.getLinePoints();
        if (colIndex > 0 && points.get(colIndex - 1)) {
            return colIndex - 1;
        }
        if (colIndex < points.size() && points.get(colIndex)) {
            return colIndex + 1;
        }
        return colIndex;
    }

    public int getFinalColumnIndex(int startColIndex, Ladder ladder) {
        int currentColIndex = startColIndex;
        for (LinePoints linePoints : ladder.getLines()) {
            currentColIndex = changeRowLocation(currentColIndex, linePoints);
        }
        return currentColIndex;
    }

    public Map<Integer, Integer> calculateResults(Ladder ladder) {
        Map<Integer, Integer> resultMap = new LinkedHashMap<>();

        for (int start = 0; start < ladder.getCols(); start++) {
            int end = getFinalColumnIndex(start, ladder);
            resultMap.put(start, end);
        }

        return resultMap;
    }


}
