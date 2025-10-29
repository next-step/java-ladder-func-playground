package domain;

import java.util.List;

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


}
