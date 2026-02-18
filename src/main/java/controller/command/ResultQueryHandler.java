package controller.command;

import domain.player.PlayerResults;
import view.OutputView;

public interface ResultQueryHandler {

    boolean matches(String command);

    boolean handle(PlayerResults playerResults, OutputView outputView, String input);
}
