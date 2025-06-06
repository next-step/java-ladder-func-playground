package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }

    public static Line create(int width) {
        Random random = new Random();
        List<Boolean> points = new ArrayList<>();
        return new Line(IntStream.range(0, width - 1)
            .mapToObj(i -> shouldConnect(points, i, random))
            .collect(Collectors.toList()));
    }

    private static boolean shouldConnect(List<Boolean> points, int index, Random random) {
        boolean connection = (index <= 0 || !points.get(index - 1)) && random.nextBoolean();
        points.add(connection);
        return connection;
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
