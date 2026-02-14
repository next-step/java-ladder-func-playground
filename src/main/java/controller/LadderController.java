package controller;

import controller.command.QueryCommand;
import domain.ladder.Ladder;
import domain.ladder.LadderFactory;
import domain.ladder.LadderGameRules;
import domain.player.PlayerResults;
import domain.player.Players;
import domain.player.Rewards;
import exception.DomainException;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final LadderFactory ladderFactory;
    private final InputView inputView;
    private final OutputView outputView;

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
        outputView.printLadderGameResult(ladder.lines(), players.names(), rewards.values());
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
        String nameForResult = readPlayNameForResult();

        if (nameForResult.equals(QueryCommand.QUIT)) {
            return false;
        }
        if (nameForResult.equals(QueryCommand.ALL)) {
            outputView.printAllResult(playerResults.findAllResults());
            return false;
        }
        tryPrintResultByName(playerResults, nameForResult);

        return true;
    }

    private String readPlayNameForResult() {
        outputView.printPlayerNameForResultPrompt();
        return inputView.readPlayerNameForResult();
    }

    private void tryPrintResultByName(PlayerResults playerResults, String nameForResult) {
        try {
            outputView.printOneResult(playerResults.findResultByName(nameForResult));
        } catch (DomainException e) {
            outputView.printError(e.getMessage());
        }
    }
}
