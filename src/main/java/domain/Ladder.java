package domain;

import generator.ConnectionGenerator;

import java.util.List;

public class Ladder {
    private final List<Row> ladder;

    public Ladder(List<Row> ladder) {
        this.ladder = ladder;
    }

    public void createLadder(int width, int height, ConnectionGenerator connectionGenerator) {
        for (int i = 0; i < height; i++) {
            ladder.add(Row.of(width - 1, connectionGenerator));
        }
    }

    public List<List<Boolean>> toBooleanLists() {
        return ladder.stream()
                .map(Row::getRow)
                .toList();
    }
}
