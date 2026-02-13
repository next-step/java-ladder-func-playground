package domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.DomainRuleViolationException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RewardsTest {

    @DisplayName("실행 결과가 입력되지 않으면 예외가 발생한다")
    @Test
    void throwExceptionWhenRewardsEmpty() {
        // given
        List<String> emptyRewards = List.of();

        // when & then
        assertThatThrownBy(() -> new Rewards(emptyRewards))
                .isInstanceOf(DomainRuleViolationException.class);
    }

    @DisplayName("실행 결과 입력값이 공백이면 예외가 발생한다")
    @Test
    void throwExceptionWhenRewardIsBlank() {
        // given
        List<String> rewards = List.of("꽝", "  ", "당첨");

        // when & then
        assertThatThrownBy(() -> new Rewards(rewards))
                .isInstanceOf(DomainRuleViolationException.class);
    }

    @DisplayName("올바른 실행 결과로 Rewards를 생성한다")
    @Test
    void createRewards() {
        // given
        List<String> values = List.of("꽝", "5000", "당첨");

        // when
        Rewards rewards = new Rewards(values);

        // then
        assertThat(rewards.size()).isEqualTo(3);
    }

}
