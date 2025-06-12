package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private static final Random random = new Random();
    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }

    public static Line create(int width) {
        List<Boolean> connections = new ArrayList<>();
        for (int i = 0; i < width - 1; i++) {
            // 새로운 라인 연결 여부
            boolean shouldConnect = isConnectable(i, connections);
            connections.add(shouldConnect);
        }
        return new Line(connections);
    }

    private static boolean isConnectable(int currentIndex, List<Boolean> connections) {
        // 첫 번째 위치라면? 바로 Random 값 설정
        if (currentIndex == 0) {
            return random.nextBoolean();
        }

        // 바로 이전 연결 여부를 확인 -> 연속된 라인(true) 방지
        boolean previousConnected = connections.get(currentIndex - 1);
        return !previousConnected && new Random().nextBoolean();
    }
}
