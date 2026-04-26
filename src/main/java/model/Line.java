package model;

import java.util.List;

import static constants.ErrorMessage.CONSECUTIVE_STEPS_IN_A_ROW;

public record Line (List<Step> steps){
    public Line(List<Step> steps) {
        this.varifyLine(steps);
        this.steps = steps;
    }

    private void varifyLine(List<Step> steps) {
        int width = steps.size();
        for (int i = 0; i < width - 1; i++) {
            boolean currentStepIsBlank = steps.get(i).isBlank();
            boolean nextStepIsBlank= steps.get(i + 1).isBlank();

            if(!currentStepIsBlank && !nextStepIsBlank) {
                throw new IllegalArgumentException(CONSECUTIVE_STEPS_IN_A_ROW);
            }
        }
    }

    @Override
    public String toString() {
        String result = "|";

        for (Step currentStep: steps) {
            result += currentStep.toString();
            result += "|";
        }

        return result;
    }
}
