package ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResultMap {
    private final Map<String, String> resultMap = new LinkedHashMap<>();
    private final List<String> names;
    private final List<String> results;
    private final List<Integer> resultSeq;

    public ResultMap(List<String> names, List<String> results, List<Integer> resultSeq){
        this.names = names;
        this.results = results;
        this.resultSeq = resultSeq;
        makeResultMap();
    }

    private void makeResultMap(){
        for(int i = 0; i < names.size(); i++){
            resultMap.put(names.get(i), results.get(resultSeq.get(i)));
        }
    }

    public Map<String, String> getResultMap(){
        return resultMap;
    }
}
