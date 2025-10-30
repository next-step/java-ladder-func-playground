package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class Bridge {

    private final List<List<BridgeStep>> rows;
    private final Random random = new Random();

    public Bridge(int height, int width) {
        this.rows = new ArrayList<>();
        initializeBridgeRows(height, width);
    }

    private void initializeBridgeRows(int height, int width) {
        for (int i = 0; i < height; i++) {
            this.rows.add(createOneRow(width));
        }
    }

    private List<BridgeStep> createOneRow(int width) {
        List<BridgeStep> row = generateRandomRow(width);
        ensureNoSideBySideSteps(row);
        return row;
    }

    private List<BridgeStep> generateRandomRow(int width) {
        List<BridgeStep> row = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            row.add(BridgeStep.createRandomStep(this.random));
        }
        return row;
    }

    private void ensureNoSideBySideSteps(List<BridgeStep> row) {
        for (int i = 0; i < row.size() - 1; i++) {
            fixSideBySideStepIfNeeded(row, i);
        }
    }

    private void fixSideBySideStepIfNeeded(List<BridgeStep> row, int index) {
        if (areBothStepsExisting(row, index)) {
            setOneToNoneRandomly(row, index);
        }
    }


    private boolean areBothStepsExisting(List<BridgeStep> row, int index) {
        return row.get(index).isExist() && row.get(index + 1).isExist();
    }

    private void setOneToNoneRandomly(List<BridgeStep> row, int index) {
        if (this.random.nextBoolean()) {
            row.set(index, BridgeStep.NONE);
            return;
        }
        row.set(index + 1, BridgeStep.NONE);
    }

    public List<List<BridgeStep>> getRows() {
        return Collections.unmodifiableList(this.rows);
    }
}
