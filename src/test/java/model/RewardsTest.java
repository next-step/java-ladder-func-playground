package model;

import Model.Rewards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardsTest {
    @Test
    @DisplayName("보상 목록은 쉼표로 구분되어 생성된다")
    void rewardsAreSplit() {
        // given
        var expected1 = "꽝";
        var expected2 = "5000";

        String inputRewards = "꽝,5000,꽝";
        List<String> rewardNames = Arrays.asList(inputRewards.split(","));

        // when
        Rewards rewards = new Rewards(rewardNames);

        // then
        assertEquals(expected1, rewards.getReward(0));
        assertEquals(expected2, rewards.getReward(1));
    }
}
