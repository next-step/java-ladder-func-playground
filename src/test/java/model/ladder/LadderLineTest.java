package model.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderLineTest {

    private final static int RIGHT_MOVE_DIRECTION = 1;
    private final static int STRAIGHT_MOVE_DIRECTION = 0;
    private final static int LEFT_MOVE_DIRECTION = -1;

    @Test
    public void 한_라인_내에_생성된_사다리_지점의_수는_플레이어의_수와_일치해야_한다(){
        int playerCount = 5;
        LadderLine ladderLine = new LadderLine(playerCount);

        List <LadderPoint> ladderPoints = ladderLine.getLadderLine();
        assertThat(ladderPoints.size()).isEqualTo(playerCount);

    }

    @Test
    @DisplayName("왼쪽으로 이동 가능할 경우")
    public void 플레이어가_이동_가능한_방향을_결정해줄_수_있다_1(){
        LadderLine ladderLine = new LadderLine(5);

        int leftPointPosition = 0;
        int currentPlayerPosition = 1;
        LadderPoint leftLadderPoint = LadderPoint.CONNECTED;
        LadderPoint currentLadderPoint = LadderPoint.DISCONNECTED;

        List<LadderPoint> ladderPoints = ladderLine.getLadderLine();
        ladderPoints.set(leftPointPosition, leftLadderPoint);
        ladderPoints.set(currentPlayerPosition,currentLadderPoint);

        int direction = ladderLine.determinePlayerPossibleDirection(currentPlayerPosition);
        assertThat(direction).isEqualTo(LEFT_MOVE_DIRECTION);
    }

    @Test
    @DisplayName("오른쪽으로 이동 가능할 경우")
    public void 플레이어가_이동_가능한_방향을_결정해줄_수_있다_2(){
        LadderLine ladderLine = new LadderLine(5);
        LadderPoint currentLadderPoint = LadderPoint.CONNECTED;
        LadderPoint rightLadderPoint = LadderPoint.DISCONNECTED;

        int currentPlayerPosition = 1;
        int rightPointPosition = 2;

        List<LadderPoint> ladderPoints = ladderLine.getLadderLine();
        ladderPoints.set(currentPlayerPosition,currentLadderPoint);
        ladderPoints.set(rightPointPosition, rightLadderPoint);

        int direction = ladderLine.determinePlayerPossibleDirection(currentPlayerPosition);
        assertThat(direction).isEqualTo(RIGHT_MOVE_DIRECTION);
    }

    @Test
    @DisplayName("아래로 이동 가능할 경우")
    public void 플레이어가_이동_가능한_방향을_결정해줄_수_있다_3(){
        LadderLine ladderLine = new LadderLine(5);
        LadderPoint lefrLadderPoint = LadderPoint.DISCONNECTED;
        LadderPoint currentLadderPoint = LadderPoint.DISCONNECTED;

        int leftPointPosition = 0;
        int currentPlayerPosition = 1;

        List<LadderPoint> ladderPoints = ladderLine.getLadderLine();
        ladderPoints.set(currentPlayerPosition,currentLadderPoint);
        ladderPoints.set(leftPointPosition, lefrLadderPoint);

        int direction = ladderLine.determinePlayerPossibleDirection(currentPlayerPosition);
        assertThat(direction).isEqualTo(STRAIGHT_MOVE_DIRECTION);
    }
}
