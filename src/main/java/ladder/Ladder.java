package ladder;

import strategy.LinkStrategy;
import tuner.LadderTuner;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(Height height, Width width, LinkStrategy strategy, LadderTuner tuner) {
        //1. 일단 Random 기반으로 사다리 완전체 만듦
        this.lines = new ArrayList<>();
        for (int row = 0; row < height.height(); row++) {
            lines.add(new Line(width, strategy));
        }
        //2. Random 기반이라 이상한 부분 보정
        tuner.tune(this, height, width);
    }

    public boolean hasLinkAt(int rowIndex, int colIndex) {
        return lines.get(rowIndex).isLinkedAt(colIndex);
    }

    public void addLinkAt(int rowIndex, int colIndex) {

        lines.get(rowIndex).linkAt(colIndex);
    }

    public void removeLinkAt(int rowIndex, int colIndex) {

        lines.get(rowIndex).unlinkAt(colIndex);
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }

}



