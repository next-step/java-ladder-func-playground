import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> line = new ArrayList<>();

    public Ladder(int width, int height) {
        for (int i = 0; i < height; i++) {
            line.add(new Line(width));
        }
    }

    public void printLadder() {
        for (Line line : line) {
            System.out.println(line);
        }
    }
}
