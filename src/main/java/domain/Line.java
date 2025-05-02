package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int MINIMUM_PLAYER_COUNT = 2;
    public static final boolean CONNECTED = true;
    public static final boolean NOT_CONNECTED = false;

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line create(BooleanGenerator generator, int numberOfPlayers) {
        validate(generator, numberOfPlayers);

        List<Boolean> points = new ArrayList<>();
        boolean previous = NOT_CONNECTED;
        for (int i = 0; i < numberOfPlayers - 1; i++) {
            boolean point = adjustPoint(generator.generate(), previous);
            points.add(point);
            previous = point;
        }
        return new Line(points);
    }

    public static boolean adjustPoint(boolean generatedBoolean, boolean previous) {
        if (previous == CONNECTED) {
            return NOT_CONNECTED;
        }
        return generatedBoolean;
    }

    public int Move(int position) {
        return findDirection(position).move(position);
    }

    private Direction findDirection(int position) {
        return List.of(Direction.RIGHT, Direction.LEFT).stream()
                .filter(direction -> direction.canMove(points, position))
                .findFirst()
                .orElse(Direction.DOWN);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private static void validate(BooleanGenerator generator, int numberOfPlayers) {
        if (generator == null) {
            throw new IllegalArgumentException("BooleanGenerator는 null일 수 없습니다.");
        }
        if (numberOfPlayers < MINIMUM_PLAYER_COUNT) {
            throw new IllegalArgumentException("플레이어 수는 2명 이상이어야 합니다.");
        }
    }
}
