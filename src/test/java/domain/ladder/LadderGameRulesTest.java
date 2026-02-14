package domain.ladder;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.player.Players;
import domain.player.Rewards;
import exception.DomainRuleViolationException;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameRulesTest {

    @DisplayName("player와 reward의 개수가 다르면 예외가 발생한다")
    @Test
    void throwExceptionWhenCountMismatch() {
        // given
        Players players = Players.of(List.of("a", "b", "c"), Set.of());
        Rewards rewards = new Rewards(List.of("꽝", "당첨"));

        // when & then
        assertThatThrownBy(() -> LadderGameRules.validateMatch(players, rewards))
                .isInstanceOf(DomainRuleViolationException.class);
    }

    @DisplayName("player와 reward의 개수가 같으면 예외가 발생하지 않는다")
    @Test
    void validateMatchSuccess() {
        // given
        Players players = Players.of(List.of("a", "b", "c"), Set.of());
        Rewards rewards = new Rewards(List.of("꽝", "5000", "당첨"));

        // when & then
        assertThatCode(() -> LadderGameRules.validateMatch(players, rewards))
                .doesNotThrowAnyException();
    }
}
