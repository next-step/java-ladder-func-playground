package view;

import java.util.List;

import domain.Ladder;
import domain.Line;

public class OutputView {

    public void printLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (int i = 0; i < 4; i++) {
            System.out.println(lineToString(lines.get(i)));
        }
    }

    private String lineToString(Line line) {
        StringBuilder lineString = new StringBuilder();
        line.getPoints().forEach(point -> {
            if (point) {
                lineString.append("|----");
                return;
            }
            lineString.append("|    ");
        });
        return lineString.toString();
    }
}
