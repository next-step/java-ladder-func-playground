package tuner;

import ladder.Height;
import ladder.Ladder;
import ladder.Width;
import strategy.LinkStrategy;

import java.util.List;
import java.util.stream.IntStream;

public class DefaultLadderTuner implements LadderTuner {
    private final LinkStrategy strategy;

    public DefaultLadderTuner(LinkStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void tune(Ladder ladder, Height height, Width width) {
        int totalRows = height.height();
        int totalColumns = width.width() - 1;

        for (int col = 0; col < totalColumns; col++) {
            adjustLinksInColumn(ladder, totalRows, col, totalColumns);
        }
    }

    private void adjustLinksInColumn(Ladder ladder, int totalRows, int col, int totalColumns) {
        //한 열에서 연결된 사다리가 몇 개인지 센다.
        int connectedCount = countLinksInColumn(ladder, totalRows, col);

        //한 열이 모두 연결이 안 되어 있다면 한 개 연결해주기
        if (connectedCount == 0) {
            addLinkInColumn(ladder, totalRows, col, totalColumns);
            return;
        }

        //한 열이 모두 연결이 되어 있다면 한 개 연결 풀기
        if (connectedCount == totalRows) {
            removeLinkInColumn(ladder, totalRows, col);
        }
    }

    private int countLinksInColumn(Ladder ladder, int totalRows, int col) {
        return (int) IntStream.range(0, totalRows)
                .filter(row -> ladder.hasLinkAt(row, col))
                .count();
    }

    private void addLinkInColumn(Ladder ladder, int totalRows, int col, int totalColumns) {
        List<Integer> candidates = IntStream.range(0, totalRows)
                .filter(row -> isLinkable(ladder, row, col))
                .boxed()
                .toList();

        if (candidates.isEmpty()) return;

        int picked = candidates.get(strategy.pickRow(candidates.size()));

        if (shouldUnlinkRight(ladder, picked, col, totalColumns)) {
            ladder.removeLinkAt(picked, col + 1);
        }

        ladder.addLinkAt(picked, col);
    }

    private void removeLinkInColumn(Ladder ladder, int totalRows, int col) {
        List<Integer> candidates = IntStream.range(0, totalRows)
                .filter(row -> ladder.hasLinkAt(row, col))
                .boxed()
                .toList();

        if (candidates.isEmpty()) return;

        int picked = candidates.get(strategy.pickRow(candidates.size()));
        ladder.removeLinkAt(picked, col);
    }

    private boolean isLinkable(Ladder ladder, int row, int col) {
        return col <= 0 || !ladder.hasLinkAt(row, col - 1);
    }

    private boolean shouldUnlinkRight(Ladder ladder, int row, int col, int totalColumns) {
        return col < totalColumns - 1 && ladder.hasLinkAt(row, col + 1);
    }
}
