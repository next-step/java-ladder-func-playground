package model;

import java.util.ArrayList;
import java.util.List;

public class LadderBuilder {
    private final LineBuilder lineBuilder;
    public LadderBuilder(LineBuilder lineBuilder) {
        this.lineBuilder = lineBuilder;
    }

    public Ladder generateLadder(int height, int width) {
        List<Line> lineList = new ArrayList<>();

        while (height-- > 0) {
            lineList.add(lineBuilder.buildLine(width));
        }

        return new Ladder(lineList);
    }
}
