package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import strategy.PointGenerator;

public class Line {

    private final List<Point> points;

    private Line(final List<Point> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public static Line create(final int width, final PointGenerator generator) {
        return new Line(generatePoints(width, generator));
    }

     /**
     * 주어진 너비와 PointGenerator를 바탕으로, 왼쪽에서 오른쪽 방향으로 연결된 Point 리스트를 생성한다.
     * 첫 번째 Point는 {@code Point.first()} 를 통해 생성되며,
     * 이후 Point는 이전 Point의 연결 상태를 기준으로 오른쪽으로 순차적으로 생성된다.
     * <p>
     * * 사다리는 왼쪽에서 오른쪽으로만 연결된다는 전제 하에 동작한다.

     * @param width 사다리의 너비
     * @param generator 오른쪽 연결 여부를 결정하는 PointGenerator
     * @return 연결된 Point 리스트
     */
    private static List<Point> generatePoints(final int width, final PointGenerator generator) {
        List<Point> points = new ArrayList<>();
        Point first = Point.first(generator.generate());
        points.add(first);

        for (int i = 1; i < width; i++) {
            first = first.connectNext(generator.generate());
            points.add(first);
        }

        return points;
    }

    public List<Point> getPoints() {
        return points;
    }
}
