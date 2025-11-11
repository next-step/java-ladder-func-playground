package domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerNameTest {
    @Test
    void null은_허용되지_않는다() {
        // when & then
        assertThatThrownBy(() -> new PlayerName(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 빈문자열은_허용되지_않는다() {
        // when & then
        assertThatThrownBy(() -> new PlayerName("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름은_5글자를_초과할_수_없다() {
        // when & then
        assertThatThrownBy(() -> new PlayerName("태우태우태우"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상_이름이면_생성된다() {
        // given
        String name = "태우";

        // when
        PlayerName playerName = new PlayerName(name);

        // then
        assertThat(playerName.value()).isEqualTo(name);
    }
}
