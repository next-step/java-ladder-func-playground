package model.player;

import model.ladder.Ladder;
import model.ladder.LadderLine;

public class Player {

    private final PlayerName playerName;
    private final Position position;

    public Player(PlayerName playerName, Position position) {
        this.playerName = playerName;
        this.position = position;
    }

    public void climbLadder(Ladder ladder) {
        for (LadderLine ladderLine : ladder.getLadder()) {

            int direction = ladderLine.determinePlayerPossibleDirection(getPosition());

            moveByDirection(direction);
        }
    }

    private void moveByDirection(int direction) {
        position.move(direction);
    }

    public String getName() {
        return playerName.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
