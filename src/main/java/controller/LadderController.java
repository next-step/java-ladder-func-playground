package controller;

import domain.Ladder;
import domain.Size;
import view.InputView;
import view.LadderView;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderController {
    private Size size;
    private Ladder ladder;

    public void run() {
        size = InputView.readSize();
        ladder = Ladder.create(size);
        LadderView.printLadder(ladder);

        Map<Integer, Integer> results = play();
        LadderView.printResults(results);
    }

    private Map<Integer, Integer> play() {
        Map<Integer, Integer> results = new LinkedHashMap<>();
        for (int i = 0; i < size.getWidth(); i++) {
            int result = ladder.move(i);
            results.put(i, result);
        }
        return results;
    }
}
