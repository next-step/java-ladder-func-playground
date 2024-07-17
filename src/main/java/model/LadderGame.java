package model;

import view.InputView;
import view.OutputView;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;

    private Players players;
    private Results results;
    private Ladder ladder;

    public LadderGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        players = inputView.readPlayers();
        results = inputView.readResults(players.getPlayerCount());
        Integer ladderHeight = inputView.readLadderHeight();
        ladder = new Ladder(players.getPlayerCount(), ladderHeight);
        outputView.printLadderGameResult(this);
        String name;
        do {
            name = inputView.readResultPlayerName();
            outputView.printResult(this, name);
        } while(!name.equals("all"));
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Players getPlayers() {
        return players;
    }

    public Results getResults() {
        return results;
    }
}
