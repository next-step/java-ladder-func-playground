package model;

import Model.Bridge;
import Model.BridgeStep;
import Model.LadderDescentService;
import Model.Player;
import Model.Rewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("사다리 게임 모델 테스트")
public class LadderGameModelTest {

    @Test
    @DisplayName("플레이어 이름은 쉼표로 구분되어 생성된다")
    void playerNamesAreSplit() {
        // given
        String inputNames = "pobi,crong,honux";

        // when
        Player players = new Player(inputNames);
        List<String> playerList = players.getPlayers();

        // then
        assertThat(playerList).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("보상 목록은 쉼표로 구분되어 생성된다")
    void rewardsAreSplit() {
        // given
        String inputRewards = "꽝,5000,꽝";

        // when
        Rewards rewards = new Rewards(inputRewards);

        // then
        assertEquals("꽝", rewards.getRewardskey(0));
        assertEquals("5000", rewards.getRewardskey(1));
    }

    @Test
    @DisplayName("사다리 이동 - 연결선이 없으면 그대로 내려간다")
    void moveStaysWhenNoConnection() {
        // given
        List<BridgeStep> row = Arrays.asList(BridgeStep.NONE, BridgeStep.NONE, BridgeStep.NONE);
        Bridge bridge = new Bridge(Collections.singletonList(row));
        LadderDescentService descentService = new LadderDescentService(bridge);
        int initialPosition = 1;

        // when
        int newPosition = descentService.descent(initialPosition);

        // then
        assertEquals(initialPosition, newPosition);
    }

    @Test
    @DisplayName("사다리 이동 - 오른쪽에 연결선이 있으면 오른쪽으로 이동한다")
    void movesRightWhenConnectionExists() {
        // given
        List<BridgeStep> row = Arrays.asList(BridgeStep.NONE, BridgeStep.EXIST, BridgeStep.NONE);
        Bridge bridge = new Bridge(Collections.singletonList(row));
        LadderDescentService descentService = new LadderDescentService(bridge);
        int initialPosition = 1;

        // when
        int newPosition = descentService.descent(initialPosition);

        // then
        assertEquals(2, newPosition);
    }

    @Test
    @DisplayName("사다리 이동 - 왼쪽에 연결선이 있으면 왼쪽으로 이동한다")
    void movesLeftWhenConnectionExists() {
        // given
        List<BridgeStep> row = Arrays.asList(BridgeStep.EXIST, BridgeStep.NONE, BridgeStep.NONE);
        Bridge bridge = new Bridge(Collections.singletonList(row));
        LadderDescentService descentService = new LadderDescentService(bridge);
        int initialPosition = 1;

        // when
        int newPosition = descentService.descent(initialPosition);

        // then
        assertEquals(0, newPosition);
    }

    @Test
    @DisplayName("사다리 이동 - 가장 왼쪽에서는 오른쪽으로만 이동할 수 있다")
    void movesRightFromLeftmostPosition() {
        // given
        List<BridgeStep> row = Arrays.asList(BridgeStep.EXIST, BridgeStep.NONE, BridgeStep.NONE);
        Bridge bridge = new Bridge(Collections.singletonList(row));
        LadderDescentService descentService = new LadderDescentService(bridge);
        int initialPosition = 0;

        // when
        int newPosition = descentService.descent(initialPosition);

        // then
        assertEquals(1, newPosition);
    }

    @Test
    @DisplayName("사다리 이동 - 가장 오른쪽에서는 왼쪽으로만 이동할 수 있다")
    void movesLeftFromRightmostPosition() {
        // given
        List<BridgeStep> row = Arrays.asList(BridgeStep.NONE, BridgeStep.EXIST, BridgeStep.NONE);
        Bridge bridge = new Bridge(Collections.singletonList(row));
        LadderDescentService descentService = new LadderDescentService(bridge);
        int initialPosition = 2;

        // when
        int newPosition = descentService.descent(initialPosition);

        // then
        assertEquals(1, newPosition);
    }
}