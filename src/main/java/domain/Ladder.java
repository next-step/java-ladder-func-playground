package domain;

import generator.ConnectionGenerator;

import java.util.List;

public class Ladder {
    private static final int COLUMN_LENGTH = 4;
    private static final int ROW_LENGTH = 4;
    private final List<Row> ladder;

    public Ladder(List<Row> ladder) {
        this.ladder = ladder;
    }

    public void createLadder(ConnectionGenerator connectionGenerator) {
        for (int i = 0; i < COLUMN_LENGTH; i++) {
            ladder.add(Row.of(ROW_LENGTH - 1, connectionGenerator));
        }
    }

    public List<List<Boolean>> toBooleanLists() {
        return ladder.stream()
                .map(Row::getRow)
                .toList();
    }
}
