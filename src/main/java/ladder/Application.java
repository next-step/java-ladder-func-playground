package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
import ladder.domain.LadderWidth;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        LadderWidth width = InputView.inputWidth();
        LadderHeight height = InputView.inputHeight();

        Ladder ladder = Ladder.of(width, height);

        OutputView.printLadder(ladder);
    }

}
