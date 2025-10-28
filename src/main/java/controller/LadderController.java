package controller;

import model.Ladder;
import model.LadderSize;
import model.Line;
import model.LadderFactory;
import model.LadderGame;
import model.BuildLine;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderController {
    private final LadderFactory factory = new LadderFactory();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {

        List<String> participants = inputView.inputParticipants();
        int width = participants.size();

        List<String> results = inputView.inputResults();
        int height = inputView.heightSize();

        LadderSize size = new LadderSize(width, height);
        Ladder ladder = factory.create(size, width);

        List<String> lines = new ArrayList<>();
        for (Line line : ladder.lines()) {
            lines.add(BuildLine.build(line));
        }

        outputView.printLadder(participants, lines, results);

        ladderGame(ladder, participants, results);
    }

    public void ladderGame(Ladder ladder, List<String> participants, List<String> results) {
        LadderGame game = new LadderGame(ladder, participants.size());

        while (true) {
            String queryName = inputView.inputQueryName();

            if ("all".equals(queryName)) {
                Map<String, String> allResults = new LinkedHashMap<>();
                for (int i = 0; i < participants.size(); i++) {
                    int finalPosition = game.play(i);
                    allResults.put(participants.get(i), results.get(finalPosition));
                }
                outputView.printAllResults(allResults);
                break;
            } else {
                int startIndex = participants.indexOf(queryName);
                if (startIndex == -1) {
                    System.out.println("존재하지 않는 이름입니다.");
                    continue;
                }

                int finalPosition = game.play(startIndex);
                String result = results.get(finalPosition);
                outputView.printSingleResult(queryName, result);
            }
        }
    }
}
