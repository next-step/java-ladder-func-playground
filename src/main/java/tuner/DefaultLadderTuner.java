package tuner;

import ladder.Row;
import ladder.Ladder;
import ladder.Column;
import strategy.LinkStrategy;

import java.util.List;
import java.util.stream.IntStream;

public class DefaultLadderTuner implements LadderTuner {
    private final LinkStrategy strategy;

    public DefaultLadderTuner(LinkStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void tune(Ladder ladder, Row rows, Column columns) {
        int totalRows = rows.value();
        int totalColumns = columns.value() - 1;

        for (int column = 0; column < totalColumns; column++) {
            adjustLinksInColumn(ladder, totalRows, column, totalColumns);
        }
    }

    private void adjustLinksInColumn(Ladder ladder, int totalRows, int column, int totalColumns) {
        //한 열에서 연결된 사다리가 몇 개인지 센다.
        int connectedCount = countLinksInColumn(ladder, totalRows, column);

        //한 열이 모두 연결이 안 되어 있다면 한 개 연결해주기
        if (connectedCount == 0) {
            addLinkInColumn(ladder, totalRows, column, totalColumns);
            return;
        }

        //한 열이 모두 연결이 되어 있다면 한 개 연결 풀기
        if (connectedCount == totalRows) {
            removeLinkInColumn(ladder, totalRows, column);
        }
    }

    private int countLinksInColumn(Ladder ladder, int totalRows, int column) {
        return (int) IntStream.range(0, totalRows)
                .filter(row -> ladder.hasLinkAt(row, column))
                .count();
    }

    private void addLinkInColumn(Ladder ladder, int totalRows, int column, int totalColumns) {
        List<Integer> candidates = IntStream.range(0, totalRows)
                .filter(row -> isLinkable(ladder, row, column))
                .boxed()
                .toList();

        if (candidates.isEmpty()) return;

        int picked = candidates.get(strategy.pickRow(candidates.size()));

        if (shouldUnlinkRight(ladder, picked, column, totalColumns)) {
            ladder.removeLinkAt(picked, column + 1);
        }

        ladder.addLinkAt(picked, column);
    }

    private void removeLinkInColumn(Ladder ladder, int totalRows, int column) {
        List<Integer> candidates = IntStream.range(0, totalRows)
                .filter(row -> ladder.hasLinkAt(row, column))
                .boxed()
                .toList();

        if (candidates.isEmpty()) return;

        int picked = candidates.get(strategy.pickRow(candidates.size()));
        ladder.removeLinkAt(picked, column);
    }

    private boolean isLinkable(Ladder ladder, int row, int column) {
        return column <= 0 || !ladder.hasLinkAt(row, column - 1);
    }

    private boolean shouldUnlinkRight(Ladder ladder, int row, int column, int totalColumns) {
        return column < totalColumns - 1 && ladder.hasLinkAt(row, column + 1);
    }
}
