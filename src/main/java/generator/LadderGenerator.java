package generator;

import domain.Ladder;
import domain.LinePoints;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    private final LinePointsGenerator linePointsGenerator = new LinePointsGenerator();

    public Ladder generateLadder(int colCount, int rowCount) {
        List<LinePoints> linePointsList = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            LinePoints linePoints = linePointsGenerator.generateLinePoints(colCount);
            linePointsList.add(linePoints);
        }

        return new Ladder(linePointsList, rowCount, colCount);

    }

}
