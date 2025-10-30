package Controller;

import Model.Bridge;
import Model.Player;
import Model.Rewards;
import view.InputView;
import view.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startLadder()
    {
        int height;
        boolean isAll=false;
        outputView.askPlayers();
        String inputs = inputView.getScanner().nextLine();
        Player players =new Player(inputs);

        outputView.askRewards();
        inputs = inputView.getScanner().nextLine();
        Rewards rewards = new Rewards(inputs);

        outputView.askLadderHeight();
        height = inputView.getWidthAndHeight();

        outputView.printPlayersAndRewards(players.getPlayers());
        Bridge bridge = new Bridge(height,players.getPlayersNumber()-1);
        outputView.print(bridge);

        outputView.printPlayersAndRewards(rewards.getRewards());

        players.playerOnDestination(bridge);
        inputView.getScanner().nextLine();

        while(!isAll) {
            outputView.askResults();
            String string = inputView.getScanner().nextLine();

            isAll=outputView.printRewards(rewards, players, string);
        }
    }


}
