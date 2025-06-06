package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Line {

  private final List<Boolean> points;

  private Line(List<Boolean> points) {
    this.points = points;
  }

  public static Line create(int width) {
    List<Boolean> points = new ArrayList<>();
    Random random = new Random();

    for (int i = 0; i < width - 1; i++) {
      addConnection(points, i, random);
    }

    return new Line(points);
  }

  private static void addConnection(List<Boolean> points, int index, Random random) {
    if (isConnectedToPrevious(index, points)) {
      points.add(false);
      return;
    }

    points.add(random.nextBoolean());
  }

  private static boolean isConnectedToPrevious(int index, List<Boolean> points) {
    return index > 0 && points.get(index - 1);
  }

  public void draw() {
    for (Boolean point : points) {
      System.out.print("|");
      printLine(point);
    }
    System.out.println("|");
  }

  private void printLine(Boolean connected) {
    if (connected) {
      System.out.print("-----");
      return;
    }
    System.out.print("     ");
  }
}
