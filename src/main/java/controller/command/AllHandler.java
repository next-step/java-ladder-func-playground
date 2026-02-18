package controller.command;

import domain.player.PlayerResults;
import view.OutputView;

public class AllHandler implements ResultQueryHandler {

    @Override
    public boolean matches(String command) {
        return QueryCommand.ALL.value().equals(command);
    }

    @Override
    public boolean handle(PlayerResults playerResults, OutputView outputView, String command) {
        outputView.printAllResult(playerResults.findAllResults());
        return false;
    }
}
