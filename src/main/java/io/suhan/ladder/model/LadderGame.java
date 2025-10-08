package io.suhan.ladder.model;

import io.suhan.ladder.view.OutputView;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public void execute() {
        OutputView.printResult(ladder);
        for (int start = 0; start < ladder.getWidth(); start++) {
            int end =  traverse(start);
            OutputView.printTraverseResult(start, end);
        }
    }

    private int traverse(int start) {
        int col = start;

        for (Line line: ladder.getLines()) {
            for (Connection connection : line.getConnections()) {
                if (connection.getLeft() == col) {
                    col = connection.getRight();
                    break;
                } else if (connection.getRight() == col) {
                    col = connection.getLeft();
                    break;
                }
            }
        }

        return col;
    }
}
