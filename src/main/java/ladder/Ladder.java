package ladder;

import strategy.LinkStrategy;
import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int rowCount, int columnCount, LinkStrategy strategy) {
        this.lines = new ArrayList<>();
        List<Link> prevLine = null;

        for (int row = 0; row < rowCount; row++) {
            Line line = new Line(columnCount, strategy, prevLine, row); //한 행 만들고
            lines.add(line); //집어넣고
            prevLine = line.getLinks(); //이전 행 저장
        }
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }

}



