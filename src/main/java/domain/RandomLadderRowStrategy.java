package domain;

import java.util.*;

public class RandomLadderRowStrategy implements LadderRowStrategy {
    private final Random random = new Random();

    @Override
    public List<LadderStep> generate(int count) {
        List<Boolean> bridges = new ArrayList<>();
        boolean previousBridgeExists = false;
        for (int i = 0; i < count - 1; i++) {
            previousBridgeExists = random.nextBoolean() && !previousBridgeExists;
            bridges.add(previousBridgeExists);
        }
        return convertToPoints(bridges); //bridges > point로 변환
    }

    private List<LadderStep> convertToPoints(List<Boolean> bridges) {
        List<LadderStep> points = new ArrayList<>();
        points.add(new LadderStep(0, false, bridges.get(0)));
        for (int i = 1; i < bridges.size(); i++) {
            points.add(new LadderStep(i, bridges.get(i - 1), bridges.get(i)));
        }
        points.add(new LadderStep(bridges.size(), bridges.get(bridges.size() - 1), false)); //마지막 점은 오른쪽 가로줄 없음
        return points;
    }
}
//높이 하나짜리 사다리 조각 만듦
