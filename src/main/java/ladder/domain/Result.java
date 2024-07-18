package ladder.domain;

import java.util.Objects;

public class Result {
    private final ResultMap resultMap;
    private final String resultTarget;

    public Result(ResultMap resultMap, String resultTarget) {
        this.resultMap = resultMap;
        this.resultTarget = resultTarget;
    }

    public Object getResult() {
        if (resultTarget.equals("all")) {
            return resultMap.getResultMap();
        }
        return resultMap.getResultMap().get(resultTarget);
    }
}
