package ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder create(int width, int height) {
        return new Ladder(
            IntStream.range(0, height)
                .mapToObj(i -> Line.create(width))
                .collect(Collectors.toList())
        );
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Point> result() {
        int width = lines.get(0).getPoints().size() + 1;
        return IntStream.range(0, width)
            .mapToObj(start -> new Point(start, getEndPoint(start))) // 출발점과 도착점을 Point로 묶음
            .collect(Collectors.toList());
    }

    private int getEndPoint(int start) {
        int position = start;

        for (Line line : lines) {
            position = move(position, line.getPoints());
        }

        return position;
    }

    private int move(int position, List<Boolean> points) {
        if (canMoveLeft(position, points)) {
            return position - 1;
        }

        if (canMoveRight(position, points)) {
            return position + 1;
        }

        return position;
    }

    private boolean canMoveLeft(int position, List<Boolean> points) {
        return position > 0 && points.get(position - 1);
    }

    private boolean canMoveRight(int position, List<Boolean> points) {
        return position < points.size() && points.get(position);
    }
}
