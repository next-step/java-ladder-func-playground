package Model;

import java.util.Collections;
import java.util.Map;

public class LadderResult {
    private final Map<Integer, Integer> resultMap;

    public LadderResult(Map<Integer, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public int getDestinationIndex(int startIndex) {
        return resultMap.get(startIndex);
    }

    public Map<Integer, Integer> getResultMap() {
        return Collections.unmodifiableMap(resultMap);
    }
}
