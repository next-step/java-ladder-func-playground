package domain;

import java.util.List;
import java.util.stream.IntStream;

public class LadderLine {

    private final List<Point> points;

    // 라인 겹침 로직 수정 필요
    // 삼항 제거, else 사용 불가능, depth 체크
    public LadderLine(int width, RandomStrategy strategy) {
        this.points = List.copyOf(IntStream.range(0, width)
                .mapToObj(i -> {
                    if (i == width - 1) {
                        return Point.NOT_CONNECTED;
                    }
                    return strategy.nextBoolean() ? Point.CONNECTED_RIGHT : Point.NOT_CONNECTED;
                })
                .toList());
    }

    public List<Point> getPoints() {
        return List.copyOf(points);
    }

    public int move(int currentPosition) {
        if (currentPosition < 0 || currentPosition >= points.size()) {
            return currentPosition;
        }

        Point currentPoint = points.get(currentPosition);
        return currentPoint.move(currentPosition, points.size());
    }
}
