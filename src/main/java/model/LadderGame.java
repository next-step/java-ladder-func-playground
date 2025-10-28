package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;
    private final int positions;

    public LadderGame(Ladder ladder,int width) {
        this.ladder = ladder;
        this.positions = width;
    }

    public Map<Integer, Integer> playAll() {
        Map<Integer, Integer> results = new HashMap<>();
        for (int i = 0; i < positions; i++) {
            results.put(i, play(i));
        }
        return results;
    }

    public int play(int startPosition) {
        int currentPosition = startPosition;
        List<Line> lines = ladder.lines();

        for (Line line : lines) {
            currentPosition = moveOnLine(currentPosition, line);
        }

        return currentPosition;
    }

    private int moveOnLine(int position, Line line) {
        List<Point> points = line.points();

        if (position > 0 && points.get(position - 1).isConnected()) {
            return position - 1;
        }

        if (position < points.size() && points.get(position).isConnected()) {
            return position + 1;
        }

        return position;
    }
}
