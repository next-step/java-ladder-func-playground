package strategy;

import domain.Line;
import domain.Point;
import java.util.ArrayList;
import java.util.List;

public class RandomLineGenerator implements LineGenerator {

    private final PointGenerator pointGenerator;

    public RandomLineGenerator(final PointGenerator pointGenerator) {
        this.pointGenerator = pointGenerator;
    }

    /**
     * 주어진 너비(width)와 PointGenerator를 기반으로, 왼쪽에서 오른쪽 방향으로 연결된 Point 리스트를 생성한다.
     *
     * <p>
     * 생성은 첫 번째 Point를 {@code Point.first()}를 통해 시작하며, 이후의 각 Point는 이전 Point의 상태와 PointGenerator가 제공하는 연결 여부(boolean)에
     * 따라 순차적으로 오른쪽 방향으로 생성된다.
     * </p>
     *
     * <p>
     * 이 구현은 사다리의 연결이 오직 왼쪽에서 오른쪽으로만 이루어진다는 전제를 바탕으로 동작한다.
     * </p>
     *
     * @param width 사다리 한 줄의 너비 (Point의 개수)
     * @return 연결된 Point 리스트를 담은 Line
     */
    @Override
    public Line generate(final int width) {
        List<Point> points = new ArrayList<>();
        Point first = Point.first(pointGenerator.generate());
        points.add(first);

        for (int i = 1; i < width; i++) {
            first = first.connectNext(pointGenerator.generate());
            points.add(first);
        }

        return Line.of(points);
    }
}
