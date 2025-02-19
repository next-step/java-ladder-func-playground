package model;

import java.util.*;

public class Line {
    private final List<Boolean> points;

    public Line(int count) {
        points = new ArrayList<>(Collections.nCopies(count - 1, false));
        generateRandomLadder();
    }

    private void generateRandomLadder() {
        Random random = new Random();
        for (int i = 0; i < points.size() - 1; i++) {
            if (!points.get(i) && (i == 0 || !points.get(i - 1))) {
                points.set(i, random.nextBoolean());
            }
        }
    }

    public int move(int position) {
        if (position > 0 && points.get(position - 1)) {
            return position - 1;
        }
        if (position < points.size() && points.get(position)) {
            return position + 1;
        }
        return position;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}

