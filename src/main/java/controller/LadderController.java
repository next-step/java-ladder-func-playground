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
import java.util.List;

public class LadderController {
    private final LadderFactory factory = new LadderFactory();
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void gameStart() {

        List<String> participants = inputView.inputParticipants();
        int width = participants.size();

        List<String> results;
        while (true) {
            results = inputView.inputResults();
            if (participants.size() == results.size()) {
                break;
            }
            outputView.printError("참여자 수와 결과 수가 일치하지 않습니다.");
        }

        int height;
        while (true) {
            height = inputView.heightSize();
            if (height >= 1) {
                break;
            }
            outputView.printError("높이는 1이상이어야 합니다.");
        }

        LadderSize size = new LadderSize(width, height);
        Ladder ladder = factory.create(size, width);

        List<String> lines = new ArrayList<>();
        for (Line line : ladder.lines()) {
            lines.add(BuildLine.build(line));
        }

        outputView.printLadder(participants, lines, results);

        LadderGame game = new LadderGame(ladder, participants.size());
        gameResult(game, participants, results);
    }

    private void gameResult(LadderGame game, List<String> participants, List<String> results) {
        while (true) {
            String queryName = inputView.inputQueryName();

            if ("all".equals(queryName)) {
                outputView.printAllResults(game.playAll(participants, results));
                break;
            }

            if (!participants.contains(queryName)) {
                outputView.printError("존재하지 않는 이름입니다.");
                continue;
            }

            String result = game.getResult(queryName, participants, results);
            outputView.printSingleResult(queryName, result);
        }
    }
}
