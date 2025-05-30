package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> steps;
    private static final Random RANDOM = new Random();

    public Line(List<Boolean> steps) {
        this.steps = List.copyOf(steps);
    }

    public static Line generate(int width) {
        List<Boolean> steps = new ArrayList<>();
        for (int index = 0; index < width - 1; index++) {
            steps.add(nextStep(index, steps));
        }
        return new Line(steps);
    }

    private static boolean nextStep(int index, List<Boolean> steps) {
        if (hasLeftStep(index, steps)) {
            return false;
        }
        return RANDOM.nextBoolean();
    }

    private static boolean hasLeftStep(int index, List<Boolean> steps) {
        return index > 0 && steps.get(index - 1);
    }

    public int move(int position) {
        if (canMoveLeft(position)) {
            return position - 1;
        }
        if (canMoveRight(position)) {
            return position + 1;
        }
        return position;
    }

    private boolean canMoveLeft(int position) {
        return position > 0 && steps.get(position - 1);
    }

    private boolean canMoveRight(int position) {
        return position < steps.size() && steps.get(position);
    }

    public List<Boolean> getSteps() {
        return steps;
    }
}
