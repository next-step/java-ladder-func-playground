package Controller;

import Model.Bridge;
import Model.Player;
import Model.Rewards;
import view.InputView;
import view.OutputView;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startLadder() {
        int height;

        Player players = getPlayer();

        Rewards rewards = getRewards();

        outputView.askLadderHeight();
        height = inputView.getWidthAndHeight();

        outputView.printPlayersAndRewards(players.getPlayers());
        Bridge bridge = new Bridge(height, players.getPlayersNumber() - 1);
        outputView.printBridge(bridge);

        outputView.printPlayersAndRewards(rewards.getRewards());

        players.playerOnDestination(bridge);
        inputView.getScanner().nextLine();

        boolean isAll = false;

        while (true) {
            outputView.askResults();
            String string = inputView.getScanner().nextLine();

            if(string.trim().equals("all")){outputView.printAllRewards(rewards,players);break;}
            outputView.printSpecificRewards(rewards,players,string);
        }
    }

    private Rewards getRewards() {
        outputView.askRewards();
        String rewardsInputs = inputView.getScanner().nextLine();
        return new Rewards(split(rewardsInputs));
    }

    private Player getPlayer() {
        outputView.askPlayers();
        String playerInputs = inputView.getScanner().nextLine();
        return new Player(split(playerInputs));
    }

    private static List<String> split(String input) {

        final Pattern DELIMITER = Pattern.compile(",");

        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        return DELIMITER.splitAsStream(input)
                .map(String::trim) // 양쪽 공백 제거
                .filter(name -> !name.isEmpty()) // 빈 값 제거 (예: "neo,,brie")
                .collect(Collectors.toList());
    }
}
