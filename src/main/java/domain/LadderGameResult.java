package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameResult {
    private final Map<Name, String> resultMap; //결과 저장 구조: name ->reward

    public LadderGameResult(Names names, List<String> rewards, Ladder ladder) {
        this.resultMap = new LinkedHashMap<>();
        IntStream.range(0, names.size()).forEach(i -> {
            int endPos = ladder.climb(i);
            resultMap.put(names.get(i), rewards.get(endPos)); //이름->reward로 저장
        });
    }

    public String getResult(String target) {
        return resultMap.getOrDefault(new Name(target), "해당 사용자가 없습니다.");
    }

    public String all() {
        return resultMap.entrySet().stream()
                .map(e -> e.getKey().getName() + " : " + e.getValue())
                .collect(Collectors.joining("\n"));
    }
}
