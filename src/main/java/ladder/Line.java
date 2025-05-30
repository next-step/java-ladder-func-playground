package ladder;

import strategy.LinkStrategy;
import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Link> points;

    public Line(int columnCount, LinkStrategy strategy, List<Link> prevLine, int rowIndex) {
        this.points = new ArrayList<>();

        for (int col = 0; col < columnCount - 1; col++) {
            Link link = new Link();
            applyLink(link, rowIndex, col, strategy, prevLine);
            points.add(link);
        }
    }

    private void applyLink(Link link, int row, int col, LinkStrategy strategy, List<Link> prevLine) {
        boolean isFirstCell = (row == 0 && col == 0); //첫 번째 행의 첫 번째 열
        boolean leftLinked = (col > 0) && points.get(col - 1).isLinked(); //왼쪽
        boolean aboveLinked = (prevLine != null) && prevLine.get(col).isLinked(); //위

        if (isFirstCell && strategy.canLink()) {
            link.link();
        } else if (!isFirstCell && !leftLinked && !aboveLinked) {
            link.link();
        }
    }

    public List<Link> getLinks() {
        return List.copyOf(points);
    }



}




