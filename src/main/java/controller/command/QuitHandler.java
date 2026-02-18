package controller.command;

import domain.player.PlayerResults;
import view.OutputView;

public class QuitHandler implements ResultQueryHandler{

    @Override
    public boolean matches(String command) {
        return QueryCommand.QUIT.value().equals(command);
    }

    @Override
    public boolean handle(PlayerResults playerResults, OutputView outputView, String command) {
        return false;
    }
}
