package Controller;

import Model.Bridge;
import Model.Player;
import Model.Rewards;
import view.InputView;
import view.OutputView;

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
        outputView.print(bridge);

        outputView.printPlayersAndRewards(rewards.getRewards());

        players.playerOnDestination(bridge);
        inputView.getScanner().nextLine();

        boolean isAll = false;

        while (true) {
            if(isAll)break;
            outputView.askResults();
            String string = inputView.getScanner().nextLine();

            isAll = outputView.printRewards(rewards, players, string);
        }
    }

    private Rewards getRewards() {
        outputView.askRewards();
        String inputs = inputView.getScanner().nextLine();
        return new Rewards(inputs);
    }

    private Player getPlayer() {
        outputView.askPlayers();
        String inputs = inputView.getScanner().nextLine();
        return new Player(inputs);
    }
}
