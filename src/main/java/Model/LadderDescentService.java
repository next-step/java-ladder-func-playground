package Model;

import java.util.List;

public class LadderDescentService {
    private Bridge bridge;

    public LadderDescentService(Bridge bridge) {
        this.bridge = bridge;
    }

    public int descent(int curPos){
        int pos = curPos;
        for (List<BridgeStep> row : bridge.getRows()) {
            pos += checkRightBridge(row,pos) + checkLeftBridge(row,pos);
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
