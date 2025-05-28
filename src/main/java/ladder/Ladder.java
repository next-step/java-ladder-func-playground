package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int row, int column) {
        this.lines = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            lines.add(new Line(column));
        }
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }

    public int getRow() {
        return lines.size();
    }

    //연결 로직
    public void generateLadder() {
        Random random = new Random();
        lines.forEach(line -> line.randomlyLink(random));
    }

}



