package model;

import constants.ErrorMessage;
import constants.LadderConstants;

import java.util.List;

public record Line (List<Step> steps){
    public Line(List<Step> steps) {
        this.varifyLine(steps);
        this.steps = List.copyOf(steps);
    }

    private void varifyLine(List<Step> stepList) {
        this.checkIfLineIsWideEnough(stepList);
        this.checkIfStepsAppearConsecutively(stepList);
    }

    private void checkIfLineIsWideEnough(List<Step> stepList) {
        if (stepList.isEmpty() || stepList.size() < LadderConstants.MINIMUM_LINE_WIDTH) {
            throw new IllegalArgumentException(ErrorMessage.LINE_NOT_LONG_ENOUGH);
        }
    }

    private void checkIfStepsAppearConsecutively(List<Step> stepList) {
        int width = stepList.size();
        for (int i = 0; i < width - 1; i++) {
            boolean currentStepIsBlank = stepList.get(i).isBlank();
            boolean nextStepIsBlank= stepList.get(i + 1).isBlank();

            if(!currentStepIsBlank && !nextStepIsBlank) {
                throw new IllegalArgumentException(ErrorMessage.CONSECUTIVE_STEPS_IN_A_ROW);
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
