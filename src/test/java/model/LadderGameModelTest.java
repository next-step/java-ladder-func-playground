package model;

import Model.Bridge;
import Model.BridgeRow;
import Model.BridgeStep;
import Model.LadderDescentService;
import Model.LadderResult;
import Model.Player;
import Model.Rewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("사다리 게임 모델 테스트")
public class LadderGameModelTest {

    @Test
    @DisplayName("플레이어 이름은 쉼표로 구분되어 생성된다")
    void playerNamesAreSplit() {
        // given
        String inputNames = "pobi,crong,honux";
        List<String> names = Arrays.asList(inputNames.split(","));

        // when
        Player players = new Player(names);
        List<String> playerList = players.getPlayers();

        // then
        assertThat(playerList).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("보상 목록은 쉼표로 구분되어 생성된다")
    void rewardsAreSplit() {
        // given
        String inputRewards = "꽝,5000,꽝";
        List<String> rewardNames = Arrays.asList(inputRewards.split(","));

        // when
        Rewards rewards = new Rewards(rewardNames);

        // then
        assertEquals("꽝", rewards.getReward(0));
        assertEquals("5000", rewards.getReward(1));
    }

    private Bridge createTestBridge(List<BridgeStep> steps) {
        return new Bridge(Collections.singletonList(new BridgeRow(steps.size(), new Random()) {
            @Override
            public List<BridgeStep> getSteps() {
                return steps;
            }
        }));
    }

    @Test
    @DisplayName("사다리 결과 계산 - 연결선이 없으면 그대로 내려간다")
    void calculateResultStaysWhenNoConnection() {
        // given
        Bridge bridge = createTestBridge(Arrays.asList(BridgeStep.NONE, BridgeStep.NONE, BridgeStep.NONE));
        LadderDescentService descentService = new LadderDescentService(bridge);

        // when
        LadderResult result = descentService.calculateAllResults(3);

        // then
        assertEquals(0, result.getDestinationIndex(0));
        assertEquals(1, result.getDestinationIndex(1));
        assertEquals(2, result.getDestinationIndex(2));
    }

    @Test
    @DisplayName("사다리 결과 계산 - 오른쪽으로 이동")
    void calculateResultMovesRight() {
        // given
        Bridge bridge = createTestBridge(Arrays.asList(BridgeStep.EXIST, BridgeStep.NONE, BridgeStep.NONE));
        LadderDescentService descentService = new LadderDescentService(bridge);

        // when
        LadderResult result = descentService.calculateAllResults(3);

        // then
        assertEquals(1, result.getDestinationIndex(0));
        assertEquals(0, result.getDestinationIndex(1));
        assertEquals(2, result.getDestinationIndex(2));
    }

    @Test
    @DisplayName("사다리 결과 계산 - 왼쪽으로 이동")
    void calculateResultMovesLeft() {
        // given
        Bridge bridge = createTestBridge(Arrays.asList(BridgeStep.NONE, BridgeStep.EXIST, BridgeStep.NONE));
        LadderDescentService descentService = new LadderDescentService(bridge);

        // when
        LadderResult result = descentService.calculateAllResults(3);

        // then
        assertEquals(0, result.getDestinationIndex(0));
        assertEquals(2, result.getDestinationIndex(1));
        assertEquals(1, result.getDestinationIndex(2));
    }
}