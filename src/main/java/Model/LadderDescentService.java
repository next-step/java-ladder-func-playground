package Model;

import java.util.List;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderDescentService {
    private final Bridge bridge;

    public LadderDescentService(Bridge bridge) {
        this.bridge = bridge;
    }

    public LadderResult calculateAllResults(int numberOfPlayers) {
        Map<Integer, Integer> resultMap = IntStream.range(0, numberOfPlayers)
                .boxed()
                .collect(Collectors.toMap(i -> i, this::descent));
        return new LadderResult(resultMap);
    }

    private int descent(int curPos){
        int pos = curPos;
        for (BridgeRow row : bridge.getRows()) {
            List<BridgeStep> steps = row.getSteps();
            pos += checkRightBridge(steps,pos) + checkLeftBridge(steps,pos);
        }
        return pos;
    }


    private int checkRightBridge(List<BridgeStep> row, int pos) {
        if (pos >= row.size()) {
            return 0;
        }
        if (row.get(pos) == BridgeStep.EXIST) {
            return 1;
        }
        return 0;
    }

    private int checkLeftBridge(List<BridgeStep> row, int pos) {
        if (pos == 0) {
            return 0;
        }
        if (row.get(pos - 1) == BridgeStep.EXIST) {
            return -1;
        }
        return 0;
    }


}
