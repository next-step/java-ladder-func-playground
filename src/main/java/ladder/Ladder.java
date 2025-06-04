package ladder;

import strategy.LinkStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<Line> lines;
    private final LinkStrategy strategy;

    public Ladder(Height height, Width width, LinkStrategy strategy) {
        //1. 일단 Random 기반으로 사다리 완전체 만듦
        this.lines = new ArrayList<>();
        this.strategy = strategy;
        for (int row = 0; row < height.height(); row++) {
            lines.add(new Line(width, strategy));
        }
        //2. Random 기반이라 이상한 부분 보정
        applyCorrection(width.width());
    }

    private void applyCorrection(int columnCount) {
        int rowCount = lines.size();

        for (int col = 0; col < columnCount - 1; col++) {
            //한 열에서 연결된 사다리가 몇 개인지 센다.
            int connectedLinks = countLinksInColumn(col);

            //한 열이 모두 연결이 안 되어 있다면 한 개 연결해주기
            ensureAtLeastOneLink(connectedLinks, rowCount, col, columnCount);
            //한 열이 모두 연결이 되어 있다면 한 개 연결 풀기
            ensureAtLeastOneGap(connectedLinks, rowCount, col);
        }
    }

    private void ensureAtLeastOneLink(int connectedLinks, int rowCount, int col, int columnCount) {
        if (connectedLinks != 0) return;
        //한 열에서 row 한 개 random으로 선택
        int rowToLink = strategy.pickRandomRow(rowCount);

        if (col > 0 && lines.get(rowToLink).getLinks().get(col - 1).isLinked()) {
            lines.get(rowToLink).getLinks().get(col - 1).unlink();
        }
        if (col < columnCount - 2 && lines.get(rowToLink).getLinks().get(col + 1).isLinked()) {
            lines.get(rowToLink).getLinks().get(col + 1).unlink();
        }

        lines.get(rowToLink).getLinks().get(col).link();
    }

    private void ensureAtLeastOneGap(int connectedLinks, int rowCount, int col) {
        if (connectedLinks != rowCount) return;

        int rowToUnlink = strategy.pickRandomRow(rowCount);
        lines.get(rowToUnlink).getLinks().get(col).unlink();
    }

    private int countLinksInColumn(int col) {
        return (int) lines.stream()
                .filter(line -> line.getLinks().get(col).isLinked())
                .count();
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }

}



