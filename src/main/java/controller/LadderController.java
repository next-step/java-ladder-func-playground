package controller;

import model.Ladder;
import model.Line;
import model.Point;
import model.Size;
import view.ResultView;
import java.util.ArrayList;
import java.util.List;

public class LadderController {

    private static final int LADDER_SIZE = 4;
    private final ResultView resultView = new ResultView();

    public void startLadder() {
        Ladder ladder = new Ladder(new Size(LADDER_SIZE), new Size(LADDER_SIZE));
        List<String> points = convertPointsToStringList(ladder.getLines());
        resultView.printLadder(points);
    }

    private List<String> convertPointsToStringList(List<Line> lines) {
        List<String> points = new ArrayList<>();
        for (Line line : lines) {
            points.add(Point.toStringUsingMap(line.getPoints()));
        }
        return List.copyOf(points);
    }
}

