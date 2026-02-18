package controller.command;

import domain.player.PlayerResults;
import exception.DomainException;
import view.OutputView;

public class NameHandler implements ResultQueryHandler {

    @Override
    public boolean matches(String command) {
        return true;
    }

    @Override
    public boolean handle(PlayerResults playerResults, OutputView outputView, String command) {
        try {
            outputView.printOneResult(playerResults.findResultByName(command));
        } catch (DomainException e) {
            outputView.printError(e.getMessage());
        }
        return true;
    }
}
