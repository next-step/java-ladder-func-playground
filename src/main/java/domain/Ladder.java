package domain;

import generator.ConnectionGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Row> ladder;

    public Ladder(List<Row> ladder) {
        this.ladder = new ArrayList<>(ladder);
    }

    public static Ladder of(int width, int height, ConnectionGenerator connectionGenerator) {
        List<Row> ladder = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladder.add(Row.of(width - 1, connectionGenerator));
        }
        return new Ladder(ladder);
    }

    public int rideLadder(int position){
        for(Row row: ladder){
            position = row.move(position);
        }
        return position;
    }

    public List<List<Boolean>> toBooleanLists() {
        return ladder.stream()
                .map(Row::getRow)
                .toList();
    }
}
