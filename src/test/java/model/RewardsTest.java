package model;

import Model.Rewards;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


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
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(rewards.getReward(0)).isEqualTo(expected1);
            softly.assertThat(rewards.getReward(1)).isEqualTo(expected2);
        });
    }
}
