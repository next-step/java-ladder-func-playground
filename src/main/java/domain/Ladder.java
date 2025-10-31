package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<Line> lines;

    public Ladder(Height height, int playerCount, Random random) {
        List<Line> temp = new ArrayList<>();

        for (int i = 0; i < height.getHeight(); i++) {
            temp.add(Line.create(playerCount, random));
        }
        if (height.getHeight() == 0) {
            temp.add(Line.create(playerCount, random));
        }
        this.lines = List.copyOf(temp);
    }

    public List<Line> getLines() {
        return lines;
    }
}
