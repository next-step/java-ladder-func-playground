package Controller;

import Model.Bridge;
import Model.Player;
import Model.Rewards;
import view.InputView;
import view.LadderViewFormatter;
import view.OutputView;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import Model.LadderDescentService;
import Model.LadderResult;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LadderViewFormatter formatter = new LadderViewFormatter();

    public void startLadder() {
        Player players = getPlayer();
        Rewards rewards = getRewards();
        int height = getLadderHeight();

        printLadder(players, rewards, height, formatter);

        LadderResult ladderResult = calculateLadderResult(players, height);

        processResultQueries(players, rewards, ladderResult);
    }

    private void printLadder(Player players, Rewards rewards, int height,LadderViewFormatter formatter) {
        outputView.printNamesLine(formatter.formatNamesLine(players.getPlayers()));
        Bridge bridge = Bridge.of(height, players.getPlayersNumber() - 1);
        outputView.printBridge(formatter.formatBridge(bridge));
        outputView.printRewards(formatter.formatResultsLine(rewards.getRewards()));
    }

    private LadderResult calculateLadderResult(Player players, int height) {
        Bridge bridge = Bridge.of(height, players.getPlayersNumber() - 1);
        LadderDescentService descentService = new LadderDescentService(bridge);
        return descentService.calculateAllResults(players.getPlayersNumber());
    }

    private void processResultQueries(Player players, Rewards rewards, LadderResult ladderResult) {
        while (true) {
            outputView.askResults();
            String query = inputView.getScanner().nextLine().trim();

            if (query.equals("all")) {
                outputView.printAllResults(players, rewards, ladderResult);
                break;
            }
            outputView.printSpecificResults(players, rewards, ladderResult, query);
        }
    }

    private int getLadderHeight() {
        outputView.askLadderHeight();
        return inputView.getWidthAndHeight();
    }

    private Rewards getRewards() {
        outputView.askRewards();
        String rewardsInputs = inputView.getScanner().nextLine();
        return new Rewards(inputView.split(rewardsInputs));
    }

    private Player getPlayer() {
        outputView.askPlayers();
        String playerInputs = inputView.getScanner().nextLine();
        return new Player(inputView.split(playerInputs));
    }
}
