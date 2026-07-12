package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        System.out.println("Starting Ladder Game..."); // 초기 진입 확인

        Players players = readPlayers();
        ResultItems resultItems = readResultItems(players.count());
        LadderHeight height = inputView.readHeight();
        LadderGame ladderGame = LadderGame.of(players.count(), height, new RandomGenerator());

        List<String> playerNames = players.extractNames();
        List<String> resultItemNames = resultItems.extractNames();
        outputView.printLadder(playerNames, ladderGame, resultItemNames);

        String requestName = inputView.readResultRequest();
        handleResultRequest(requestName, players, ladderGame, resultItems);
    }

    private Players readPlayers() {
        List<String> names = inputView.readPlayerNames();
        List<Player> players = names.stream()
                .map(Player::new)
                .toList();
        return new Players(players);
    }

    private ResultItems readResultItems(int expectedSize) {
        List<String> results = inputView.readResultItems();
        List<ResultItem> resultItems = results.stream()
                .map(ResultItem::new)
                .toList();
        return new ResultItems(resultItems, expectedSize);
    }

    private void handleResultRequest(String request, Players players, LadderGame ladder, ResultItems resultItems) {
        LadderGameResult gameResult = new LadderGameResult(players, resultItems, ladder);

        while (!request.equals("all")) {
            try {
                Player player = new Player(request);
                outputView.printSingleResult(player.getName(), gameResult.getSingleResultFor(player).getItem());
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 이름입니다. 다시 입력해주세요.");
            }
            request = inputView.readResultRequest();
        }

        Map<String, String> resultMap = gameResult.getAllResults().entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getName(),
                        entry -> entry.getValue().getItem()
                ));

        outputView.printAllResults(resultMap);
    }
}
