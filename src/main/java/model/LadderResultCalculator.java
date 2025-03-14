package model;

import java.util.Arrays;
import java.util.List;

public class LadderResultCalculator {

    private final LadderUsers ladderUsers;
    private final List<String> resultValues;

    public LadderResultCalculator(LadderUsers ladderUsers, String[] resultValues) {
        validateSize(ladderUsers, resultValues);

        this.ladderUsers = ladderUsers;
        this.resultValues = Arrays.stream(resultValues)
                .toList();
    }

    public String calculate(String name, Ladder ladder) {
        int index = ladderUsers.findIndexOfUserByName(name)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이름입니다."));
        int endPoint = ladder.getEndPoint(index);

        return findResultByIndex(endPoint);
    }

    private void validateSize(LadderUsers ladderUsers, String[] resultValues) {
        if (ladderUsers.size() != resultValues.length) {
            throw new IllegalArgumentException("참여자의 수와 실행 결과의 수가 일치하지 않습니다.");
        }
    }

    private String findResultByIndex(int index) {
        return resultValues.get(index);
    }

}
