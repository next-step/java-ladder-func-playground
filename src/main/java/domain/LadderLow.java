package domain;

import constant.ErrorMessage;
import domain.strategy.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class LadderLow {
    private final static int MIN_WIDTH = 2;

    private final List<Boolean> connections;

    public LadderLow(int width, BooleanGenerator booleanGenerator) {
        validateWidth(width);
        this.connections = new ArrayList<>();

        for (int i = 0; i < width - 1; i++) {
            boolean step = drawStep(i, booleanGenerator);
            connections.add(step);
        }
    }

    public List<Boolean> getConnections() {
        return List.copyOf(connections);
    }

    public int calculateNextPosition(int currentPosition) {
        if (currentPosition < connections.size() && connections.get(currentPosition)) {
            return currentPosition + 1;
        }
        if (currentPosition > 0 && connections.get(currentPosition - 1)) {
            return currentPosition - 1;
        }
        return currentPosition;
    }

    private boolean drawStep(int index, BooleanGenerator booleanGenerator) {
        if (index > 0 && connections.get(index - 1)) {
            return false;
        }
        return booleanGenerator.generate();
    }

    private void validateWidth(int width) {
        if (width < MIN_WIDTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LADDER_WIDTH.getIntFormattedMessage(MIN_WIDTH));
        }
    }
}
