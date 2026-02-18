package controller;

import controller.command.AllHandler;
import controller.command.NameHandler;
import controller.command.QueryCommand;
import controller.command.QuitHandler;
import controller.command.ResultQueryHandler;
import domain.ladder.Ladder;
import domain.ladder.LadderFactory;
import domain.ladder.LadderGameRules;
import domain.player.PlayerResults;
import domain.player.Players;
import domain.player.Rewards;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final LadderFactory ladderFactory;
    private final InputView inputView;
    private final OutputView outputView;

    private final List<ResultQueryHandler> resultQueryHandlers = List.of(
            new QuitHandler(),
            new AllHandler(),
            new NameHandler()
    );

    public LadderController(LadderFactory ladderFactory, InputView inputView,
            OutputView outputView) {
        this.ladderFactory = ladderFactory;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Players players = readPlayers();
        Rewards rewards = readRewards();
        LadderGameRules.validateMatch(players, rewards);

        int height = readLadderHeight();
        Ladder ladder = ladderFactory.create(height, players.size());
        PlayerResults playerResults = PlayerResults.of(ladder, players, rewards);
        outputView.printLadderGameResult(ladder.lines(), players.getNames(), rewards.getValues());
        runResultQueryLoop(playerResults);
    }

    private Players readPlayers() {
        outputView.printLadderGamePlayerNamesPrompt();

        return Players.of(inputView.readPlayerNames(), QueryCommand.FORBIDDEN_PLAYER_NAMES);
    }

    private Rewards readRewards() {
        outputView.printLadderGameResultPrompt();
        return new Rewards(inputView.readGameRewards());
    }

    private int readLadderHeight() {
        outputView.printLadderHeightPrompt();
        return inputView.readLadderValue();
    }

    private void runResultQueryLoop(PlayerResults playerResults) {
        boolean shouldContinue;
        do {
            shouldContinue = handleResultCommand(playerResults);
        }
        while (shouldContinue);
    }

    private boolean handleResultCommand(PlayerResults playerResults) {
        String command = readPlayNameForResult();

        return resultQueryHandlers.stream()
                .filter(handler -> handler.matches(command))
                .findFirst()
                .orElseThrow()
                .handle(playerResults, outputView, command);
    }

    private String readPlayNameForResult() {
        outputView.printPlayerNameForResultPrompt();
        return inputView.readPlayerNameForResult();
    }
}
