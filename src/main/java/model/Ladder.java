package model;

import java.util.*;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int playerCount, int height) {
        lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(playerCount));
        }
    }

    public LadderResult run(List<Player> players, List<String> results) {
        Map<String, String> resultMap = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            int finalPosition = move(i);
            resultMap.put(players.get(i).getName(), results.get(finalPosition));
        }
        return new LadderResult(resultMap);
    }

    private int move(int position) {
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    public List<Line> getLines() {
        return lines;
    }
}
