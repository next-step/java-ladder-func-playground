package ladder.controller;

import ladder.model.Line;
import ladder.model.Ladder;
import ladder.model.LinkConnector;
import ladder.view.LadderOutputView;

import java.util.List;

public class LadderController {
    LadderOutputView ladderOutputView = new LadderOutputView();
    final int LADDER_WIDTH = 4;
    final int LADDER_HEIGHT = 4;

    public void run() {
        LinkConnector linkConnector = new LinkConnector();
        Ladder ladder = new Ladder(LADDER_WIDTH, LADDER_HEIGHT, linkConnector);
        List<Line> lines = ladder.getLines();

        for (Line ladderLine : lines) {
            ladderOutputView.printLine(ladderLine.getLinks());

        }

    }
}
