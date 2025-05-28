package domain;

import java.util.Collections;
import java.util.Map;

public class LadderResult {
    private final Map<Integer, Integer> resultMap;

    public LadderResult(Map<Integer, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public Map<Integer, Integer> getResultMap() {
        return Collections.unmodifiableMap(resultMap);
    }
}
