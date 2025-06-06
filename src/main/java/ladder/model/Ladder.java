package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
  private static final int HEIGHT = 4;
  private static final int WIDTH = 4;

  private final List<Line> lines;

  private Ladder(List<Line> lines) {
    this.lines = lines;
  }

  public static Ladder create() {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < HEIGHT; i++) {
      lines.add(Line.create(WIDTH));
    }
    return new Ladder(lines);
  }

  public void draw() {
    for (Line line : lines) {
      line.draw();
    }
  }
}
