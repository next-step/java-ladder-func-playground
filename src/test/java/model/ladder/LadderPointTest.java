package model.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderPointTest {

    @Test
    @DisplayName("연결상태일 경우")
    public void 현재_사다리의_지점에서_오른쪽_지점으로_이동할_수_있다_1(){
        LadderPoint ladderPoint = LadderPoint.CONNECTED;

        assertThat(ladderPoint.isPossibleToMoveRight())
                .isTrue();
    }

    @Test
    @DisplayName("연결상태일 경우")
    public void 현재_사다리의_지점에서_왼쪽_지점으로_이동할_수_있다_2(){
        LadderPoint ladderPoint = LadderPoint.DISCONNECTED;
        LadderPoint beforeLadderPoint = LadderPoint.CONNECTED;

        assertThat(ladderPoint.isPossibleToMoveLeft(beforeLadderPoint))
                .isTrue();
    }

    @Test
    @DisplayName("연결상태가 아닐 경우")
    public void 현재_사다리의_지점에서_오른쪽_지점으로_이동할_수_없다_1(){
        LadderPoint ladderPoint = LadderPoint.DISCONNECTED;

        assertThat(ladderPoint.isPossibleToMoveRight())
                .isFalse();
    }

    @Test
    @DisplayName("연결상태가 아닐 경우")
    public void 현재_사다리의_지점에서_왼쪽_지점으로_이동할_수_없다_2(){
        LadderPoint ladderPoint = LadderPoint.DISCONNECTED;
        LadderPoint beforeLadderPoint = LadderPoint.DISCONNECTED;

        assertThat(ladderPoint.isPossibleToMoveLeft(beforeLadderPoint))
                .isFalse();
    }

    @Test
    public void 현재_사다리_지점은_다음_사다리_지점과의_연결_상태를_반환할_수_있다(){
        LadderPoint connectedLadderPoint = LadderPoint.CONNECTED;
        LadderPoint disconnectedLadderPoint = LadderPoint.DISCONNECTED;

        assertThat(connectedLadderPoint.isConnected())
                .isTrue();
        assertThat(disconnectedLadderPoint.isConnected())
                .isFalse();
    }
}
