package View;

import java.util.List;

import Domain.Ladder;
import Domain.Player;


public class ResultHandler {
    private final List<Player> players;
    private final List<String> results;
    private final Ladder ladder;

    public ResultHandler(List<Player> players, List<String> results, Ladder ladder) {
        this.players = players;
        this.results = results;
        this.ladder = ladder;
    }

    public String getIndividualResult(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                int startPosition = player.getStartPosition();
                int endPosition = ladder.getResult(startPosition);
                return results.get(endPosition);
            }
        }
        return "해당 이름의 플레이어가 없습니다.";
    }

    public void printAllResults() {
        for (Player player : players) {
            int startPosition = player.getStartPosition();
            int endPosition = ladder.getResult(startPosition);
            System.out.println(player.getName() + " : " + results.get(endPosition));
        }
    }

    public void handleResults(InputHandler inputHandler) {
        while (true) {
            String playerName = inputHandler.askPlayerName();
            if (playerName.equals("all")) {
                printAllResults();
            } else {
                String result = getIndividualResult(playerName);
                System.out.println(result);
            }
        }
    }
}
