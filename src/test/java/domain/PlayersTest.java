package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    @Test
    void 쉼표로_구분된_문자열_생성() {
        //given
        String input = "태우1,태우2";

        //when
        Players players = new Players(input);

        //then
        assertThat(players.size()).isEqualTo(2);
        assertThat(players.getPlayers().getValues())
                .extracting(Name::value)
                .containsExactly("태우1", "태우2");
    }

    @Test
    void 이름_5글자_초과시_예외발생() {
        //given
        String input = "태우태우태우";

        //when & then
        assertThatThrownBy(() -> new Players(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 넘기면 안됩니다.");
    }

    @Test
    void 중복된_이름은_저장하지_않는다() {
        //given
        String input = "태우,태우,태우1";

        //when
        Players players = new Players(input);

        //then
        assertThat(players.size()).isEqualTo(2);
        assertThat(players.getPlayers().getValues())
                .extracting(Name::value)
                .containsExactly("태우", "태우1");
    }
}
