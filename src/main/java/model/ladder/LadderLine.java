package model.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LadderLine {

    private final List<LadderPoint> ladderPoints;

    private final static int RIGHT_MOVE_DIRECTION = 1;
    private final static int STRAIGHT_MOVE_DIRECTION = 0;
    private final static int LEFT_MOVE_DIRECTION = -1;

    private final static int FIRST_INDEX = 0;

    private final static Random random = new Random();

    public LadderLine(int ladderWidth) {
        this.ladderPoints = new ArrayList<>();
        generateLadderPoints(ladderWidth);
    }

    private void generateLadderPoints(int ladderWidth) {
        for (int index = 0; index < ladderWidth - 1; index++) {
            ladderPoints.add(generateLadderPoint(index));
        }

        ladderPoints.add(LadderPoint.DISCONNECTED);
    }

    private LadderPoint generateLadderPoint(int index) {
        if(ladderPoints.isEmpty()){
            return addLadderPointByRandom();
        }

        if(beforePointIsConnected(index)){
            return LadderPoint.DISCONNECTED;
        }
        return addLadderPointByRandom();
    }

    private boolean beforePointIsConnected(int index) {
        return ladderPoints.get(index-1).isConnected();
    }

    private LadderPoint addLadderPointByRandom() {
        if (random.nextBoolean()) {
            return LadderPoint.CONNECTED;
        }
        return LadderPoint.DISCONNECTED;
    }

    public int determinePlayerPossibleDirection(int position) {
        LadderPoint ladderPoint = ladderPoints.get(position);

        if(!isLastPoint(position) && ladderPoint.isPossibleToMoveRight()){
            return RIGHT_MOVE_DIRECTION;
        }

        if(!isFirstPoint(position) && ladderPoint.isPossibleToMoveLeft(ladderPoints.get(position-1))){
            return LEFT_MOVE_DIRECTION;
        }

        return STRAIGHT_MOVE_DIRECTION;
    }

    private boolean isLastPoint(int position) {
        return position == ladderPoints.size() - 1;
    }

    private boolean isFirstPoint(int position) {
        return position == FIRST_INDEX;
    }

    public List<LadderPoint> getLadderLine() {
        return ladderPoints;
    }
}
