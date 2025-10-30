package domain;


import java.util.Map;

public class LadderResult {
    private final Map<String, String> mappedResult;

    public LadderResult(Map<String, String> mappedResult) {
        this.mappedResult = mappedResult;
    }

    public Map<String, String> getMappedResult() {
        return mappedResult;
    }


}
