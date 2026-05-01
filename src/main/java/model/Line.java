package model;

import constants.ErrorMessage;
import constants.LadderConstants;

import java.util.List;

public class Line {
    private final List<Step> steps;

    public Line(List<Step> steps) {
        this.validateLine(steps);
        this.steps = List.copyOf(steps);
    }

    private void validateLine(List<Step> stepList) {
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
            boolean nextStepIsBlank = stepList.get(i + 1).isBlank();

            if (!currentStepIsBlank && !nextStepIsBlank) {
                throw new IllegalArgumentException(ErrorMessage.CONSECUTIVE_STEPS_IN_A_ROW);
            }
        }
    }

    public Integer moveAlongTheRow(Integer index) {
        if (this.checkIfMovableToLeft(index)) {
            return index - 1;
        }

        if (this.checkIfMovableToRight(index)) {
            return index + 1;
        }

        return index;
    }

    private boolean checkIfMovableToLeft(Integer index) {
        if (index <= 0) return false;
        return !this.steps.get(index - 1).isBlank();
    }

    private boolean checkIfMovableToRight(Integer index) {
        if (index >= this.steps.size()) return false;
        return !steps.get(index).isBlank();
    }

    public Integer calculateWidth() {
        return steps.size();
    }

    public List<Step> getSteps() {
        return List.copyOf(this.steps);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("|");

        for (Step currentStep : this.steps) {
            result.append(currentStep.toString());
            result.append("|");
        }

        return result.toString();
    }
}
