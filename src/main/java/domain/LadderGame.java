package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final List<String> names;
    private final List<String> results;
    private final Ladder ladder;

    public LadderGame(List<String> names, List<String> results, Ladder ladder) {
        this.names = names;
        this.results = results;
        this.ladder = ladder;
    }

    // 특정 사람의 결과 찾기
    public String getResultForPerson(String name) {
        int startIndex = names.indexOf(name);
        if (startIndex == -1) {
            return "해당 이름을 찾을 수 없습니다.";
        }

        int finalIndex = followPath(startIndex);
        return results.get(finalIndex);
    }

    // 모든 사람의 결과 맵 반환
    public Map<String, String> getAllResults() {
        Map<String, String> resultMap = new HashMap<>();

        for (int i = 0; i < names.size(); i++) {
            int finalIndex = followPath(i);
            resultMap.put(names.get(i), results.get(finalIndex));
        }
        return resultMap;
    }

    // 사다리 경로 따라가기
    private int followPath(int startIndex) {
        int currentIndex = startIndex;
        for (Line line : ladder.getLines()) {
            currentIndex = moveToNextPosition(currentIndex, line.getPoints());
        }
        return currentIndex;
    }

    private int moveToNextPosition(int currentIndex, List<Boolean> points) {
        // 왼쪽으로 이동
        if (canMoveLeft(currentIndex, points)) {
            return currentIndex - 1;
        }
        // 오른쪽으로 이동
        if (canMoveRight(currentIndex, points)) {
            return currentIndex + 1;
        }
        // 그대로 아래로
        return currentIndex;
    }

    private boolean canMoveLeft(int currentIndex, List<Boolean> points) {
        return currentIndex > 0 && points.get(currentIndex - 1);
    }

    private boolean canMoveRight(int currentIndex, List<Boolean> points) {
        return currentIndex < points.size() && points.get(currentIndex);
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getResults() {
        return results;
    }
}
