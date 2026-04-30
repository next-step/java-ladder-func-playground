package domain;

import generator.ConnectionGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 1;
    private final List<Row> ladder;

    private Ladder(List<Row> ladder) {
        this.ladder = new ArrayList<>(ladder);
    }

    public static Ladder of(int width, int height, ConnectionGenerator connectionGenerator) {
        validateLadder(height);
        List<Row> ladder = new ArrayList<>();
        int connectionCount = width - 1;
        for (int i = 0; i < height; i++) {
            ladder.add(Row.of(connectionCount, connectionGenerator));
        }
        return new Ladder(ladder);
    }

    public int rideLadder(int position) {
        for (Row row : ladder) {
            position = row.move(position);
        }
        return position;
    }

    public List<List<Boolean>> toBooleanLists() {
        return ladder.stream()
                .map(Row::getRow)
                .toList();
    }

    private static void validateLadder(int height) {
        if (height < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 " + MIN_LADDER_HEIGHT + "이상이어야합니다.");
        }
    }
}
