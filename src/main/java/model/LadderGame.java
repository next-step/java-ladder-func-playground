package model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;
    private final int positions;

    public LadderGame(Ladder ladder,int width) {
        if (ladder == null) {
            throw new IllegalArgumentException("ladder가 null일 수 없습니다.");
        }

        this.ladder = ladder;
        this.positions = width;
    }

    public Map<String, String> playAll(List<String> participants, List<String> results) {
        Map<String, String> allResults = new LinkedHashMap<>();
        for (int i = 0; i < participants.size(); i++) {
            int finalPosition = play(i);
            allResults.put(participants.get(i), results.get(finalPosition));
        }
        return allResults;
    }

    public String getResult(String name, List<String> participants, List<String> results) {
        int startIndex = participants.indexOf(name);
        int finalPosition = play(startIndex);
        return results.get(finalPosition);
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
