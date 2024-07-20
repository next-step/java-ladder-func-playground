import java.util.List;

public class OutputHandler {
    public void printLadder(List<Player> players, Ladder ladder, List<String> results) {
        for (Player player : players) {
            System.out.print(String.format("%-6s", player.getName()));
        }
        System.out.println();

        for (Line line : ladder.getLines()) {
            System.out.println(line);
        }

        for (String result : results) {
            System.out.print(String.format("%-6s", result));
        }
        System.out.println();
    }

    public void printIndividualResult(String playerName, List<Player> players, List<String> results, Ladder ladder) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                int startPosition = player.getStartPosition();
                int endPosition = ladder.getResult(startPosition);
                System.out.println(results.get(endPosition));
                return;
            }
        }
        System.out.println("해당 이름의 플레이어가 없습니다.");
    }

    public void printAllResults(List<Player> players, List<String> results, Ladder ladder) {
        for (Player player : players) {
            int startPosition = player.getStartPosition();
            int endPosition = ladder.getResult(startPosition);
            System.out.println(player.getName() + " : " + results.get(endPosition));
        }
    }
}
