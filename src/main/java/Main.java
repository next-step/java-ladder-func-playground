import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();

        List<Player> players = inputHandler.askPlayers();
        List<String> results = inputHandler.askResults(players.size());
        int width = players.size();
        int height = inputHandler.askHeight();

        Ladder ladder = new Ladder(width, height);

        OutputHandler outputHandler = new OutputHandler();
        outputHandler.printLadder(players, ladder, results);

        while (true) {
            String playerName = inputHandler.askPlayerName();
            if (playerName.equals("all")) {
                outputHandler.printAllResults(players, results, ladder);
            } else {
                outputHandler.printIndividualResult(playerName, players, results, ladder);
            }
        }
    }
}
