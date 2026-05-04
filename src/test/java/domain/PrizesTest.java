package domain;

import constant.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizesTest {
    private static final int MAX_LENGTH = 5;

    @Test
    void 상품_수와_플레이어_수가_다르면_예외가_발생한다() {
        // given
        List<String> prizeNames = List.of("꽝", "5000");
        int playerCount = 3;

        // when-then
        assertThatThrownBy(() -> new Prizes(prizeNames, playerCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MISMATCH_PLAYER_AND_PRIZE.getMessage());
    }

    @Test
    void 상품_이름이_제한_글자수를_초과하면_예외가_발생한다() {
        // given
        List<String> prizeNames = List.of("당첨금일억천", "꽝");
        int playerCount = 2;

        // when-then
        assertThatThrownBy(() -> new Prizes(prizeNames, playerCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NAME_LENGTH.getIntFormattedMessage(MAX_LENGTH));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void 상품_이름이_비어있거나_공백이면_예외가_발생한다(String source) {
        // given
        List<String> prizeNames = List.of(source, "꽝");
        int playerCount = 2;

        // when-then
        assertThatThrownBy(() -> new Prizes(prizeNames, playerCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_OR_BLANK_NAME.getMessage());
    }
}
