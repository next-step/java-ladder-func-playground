package ladder.view;

import java.util.List;
import ladder.model.Ladder;

public class OutputView {

    public void printLadder(Ladder ladder) {
        ladder.draw();
    }

    public void printResults(List<Integer> results) {
        for (int i = 0; i < results.size(); i++) {
            System.out.println(i + " -> " + results.get(i));
        }
    }
}
