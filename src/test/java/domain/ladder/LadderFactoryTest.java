package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.DomainRuleViolationException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderFactoryTest {

    @DisplayName("참가자 수만큼의 가로 길이, 입력받은 사다리 높이만큼의 높이를 가진 사다리를 반환한다")
    @Test
    void createLadder() {
        // given
        LineIndexGenerator generator = size -> List.of(0);
        LadderFactory factory = new LadderFactory(generator);
        int height = 5;
        int playerCount = 4;

        // when
        Ladder ladder = factory.create(height, playerCount);

        // then
        assertThat(ladder.lines()).hasSize(height);
    }

    @DisplayName("잘못된 사다리 높이가 입력되면 예외가 발생한다")
    @Test
    void throwExceptionWhenInvalidHeight() {
        // given
        LineIndexGenerator generator = size -> List.of();
        LadderFactory factory = new LadderFactory(generator);

        // when & then
        assertThatThrownBy(() -> factory.create(0, 4))
                .isInstanceOf(DomainRuleViolationException.class);
    }

    @DisplayName("사다리 높이가 음수이면 예외가 발생한다")
    @Test
    void throwExceptionWhenNegativeHeight() {
        // given
        LineIndexGenerator generator = size -> List.of();
        LadderFactory factory = new LadderFactory(generator);

        // when & then
        assertThatThrownBy(() -> factory.create(-1, 4))
                .isInstanceOf(DomainRuleViolationException.class);
    }

}
