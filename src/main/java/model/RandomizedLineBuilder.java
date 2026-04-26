package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomizedLineBuilder implements LineBuilder {
    private final Random random = new Random();
    private final Integer RANDOM_MAX_INT = 10000;
    private final Integer RANDOM_MIN_INT = 1;
    private final Integer RETURNING_TRUE_LIMIT = (RANDOM_MAX_INT - RANDOM_MIN_INT + 1) / 2;

    public Line buildLine(int width) {
        List<Step> result = new ArrayList<Step>();
        for (int i = 0; i < width - 1; i ++) {
            Step newStep = getNextStep(result);
            result.add(newStep);
        }
        return new Line(result);
    }

    private Step getNextStep(List<Step> steps) {
        int stepSize=steps.size();
        if (stepSize == 0 || steps.get(stepSize - 1).isBlank()) {
            return getRandomStep();
        }

        return new Step(true);
    }

    private Step getRandomStep() {
        int chosenNumber = random.nextInt(RANDOM_MIN_INT, RANDOM_MAX_INT + 1);
        if (chosenNumber <= RETURNING_TRUE_LIMIT) {
            return new Step(true);
        }

        return new Step(false);
    }
}
