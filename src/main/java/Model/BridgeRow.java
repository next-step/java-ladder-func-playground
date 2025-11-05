package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class BridgeRow{

    private final List<BridgeStep> steps;
    RandomStepGenerator randomStepGenerator = new RandomStepGenerator();

    public BridgeRow(int width, Random random) {
        this.steps = createOneRow(width, random);
    }

    private List<BridgeStep> createOneRow(int width, Random random) {
        List<BridgeStep> row = generateRandomRow(width, random);
        ensureNoSideBySideSteps(row, random);
        return row;
    }

    private List<BridgeStep> generateRandomRow(int width, Random random) {
        List<BridgeStep> row = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            row.add(randomStepGenerator.generateStep());
        }
        return row;
    }

    private void ensureNoSideBySideSteps(List<BridgeStep> row, Random random) {
        for (int i = 0; i < row.size() - 1; i++) {
            fixSideBySideStepIfNeeded(row, i, random);
        }
    }

    private void fixSideBySideStepIfNeeded(List<BridgeStep> row, int index, Random random) {
        if (areBothStepsExisting(row, index)) {
            setOneToNoneRandomly(row, index, random);
        }
    }

    private boolean areBothStepsExisting(List<BridgeStep> row, int index) {
        return row.get(index).isExist() && row.get(index + 1).isExist();
    }

    private void setOneToNoneRandomly(List<BridgeStep> row, int index, Random random) {
        if (random.nextBoolean()) {
            row.set(index, BridgeStep.NONE);
            return;
        }
        row.set(index + 1, BridgeStep.NONE);
    }

    public List<BridgeStep> getSteps() {
        return Collections.unmodifiableList(this.steps);
    }
}
