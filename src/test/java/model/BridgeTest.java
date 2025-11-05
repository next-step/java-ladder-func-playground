package model;

import Model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeTest {
    private Bridge createTestBridge(List<BridgeStep> steps) {
        return Bridge.fromRows(Collections.singletonList(new BridgeRow(steps.size(), new Random()) {
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
