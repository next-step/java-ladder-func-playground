package controller;

import domain.*;
import view.InputView;
import view.LadderView;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderController {
    private Participants participants;
    private Results results;
    private Ladder ladder;
    private Size size;

    public void run() {
        participants = Participants.from(InputView.readParticipants());
        results = Results.from(InputView.readResults());

        size = new Size(participants.size(), InputView.readHeight());
        ladder = Ladder.create(size);

        LadderView.printLadderWithParticipants(ladder, participants);
        Map<Integer, Integer> gameResults = play();

        LadderView.printResultsWithPrizes(participants, results, gameResults);

        while (true) {
            String query = InputView.readQueryName();
            if (query.equalsIgnoreCase("all")) {
                LadderView.printAllResults(participants, results, gameResults);
                break;
            }
            int idx = participants.indexOf(query);
            if (idx == -1) {
                System.out.println("존재하지 않는 이름입니다. 다시 입력하세요.");
                continue;
            }
            LadderView.printSingleResult(query, results.get(gameResults.get(idx)));
        }
    }

    private Map<Integer, Integer> play() {
        Map<Integer, Integer> resultMap = new LinkedHashMap<>();
        for (int i = 0; i < size.getWidth(); i++) {
            int destination = ladder.move(i);
            resultMap.put(i, destination);
        }
        return resultMap;
    }
}
