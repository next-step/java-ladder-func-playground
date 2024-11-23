package controller;

import model.ladder.Ladder;
import model.ladder.LadderRow;
import model.player.Player;
import model.player.PlayerResultDto;
import model.player.PlayerResults;
import model.player.Players;
import model.tool.Splitter;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class LadderController {
    static final InputView inputView = new InputView();
    static final Splitter splitter = new Splitter();
    static final OutputView outputView = new OutputView();

    private Players createPlayers() {
        String playerNamesBeforeSplit = inputView.inputPlayers();
        String[] playerNames = splitter.splitWithComma(playerNamesBeforeSplit);
        Players players = new Players(playerNames);
        return players;
    }

    private List<String> createLadderResults() {
        String trialResultsBeforeSplit = inputView.inputResults();
        String[] trialResults = splitter.splitWithComma(trialResultsBeforeSplit);
        List<String> ladderResults = Arrays.asList(trialResults);
        return ladderResults;
    }

    private Ladder createLadder(int columnSize) {
        List<String> ladderResults = createLadderResults();
        int rowSize = inputView.inputLadderHeight();
        List<LadderRow> ladderRows = new ArrayList<>();
        for (int i = 0; i < rowSize; i++) {
            LadderRow ladderRow = new LadderRow(columnSize);
            ladderRows.add(ladderRow);
        }
        Ladder ladder = new Ladder(ladderRows, ladderResults);
        return ladder;
    }

    private PlayerResults createPlayerResults(Players players, Ladder ladder) {
        List<Player> playerInventory = players.getPlayerInventory();
        List<PlayerResultDto> playerResultsInventory = ladder.decidePlayerResults(playerInventory);
        PlayerResults playerResults = new PlayerResults(playerResultsInventory);
        return playerResults;
    }

    private void printLadder(Players players, Ladder ladder) {
        List<LadderRow> ladderRows = ladder.getLadderRows();
        List<String> ladderResults = ladder.getLadderResults();
        List<Player> playerInventory = players.getPlayerInventory();
        OutputView outputView = new OutputView();
        outputView.outputLadder(playerInventory, ladderRows, ladderResults);
    }

    public void playLadderGame() {
        Players players = createPlayers();
        Ladder ladder = createLadder(players.getPlayerInventory().size() - 1);
        PlayerResults playerResults = createPlayerResults(players, ladder);
        printLadder(players, ladder);
        String playerName;
        do {
            playerName = inputView.inputPlayerToWantResult();
            outputView.outputPlayerResult(playerResults, playerName);
        } while (!playerName.equals("all"));
    }
}
