package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class PlayerTest {

    @Test
    @DisplayName("이름에 null 값이 들어가면 예외를 던진다")
    void 이름에_null_값이_들어가면_예외를_던진다() {
        //Given
        String name = null;

        //then
        assertThatThrownBy(()->Player.create(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름에 빈문자열이 들어가면 예외를 던진다")
    void 이름에_빈문자열이_들어가면_예외를_던진다() {
        //Given
        String name = " ";

        //then
        assertThatThrownBy(()->Player.create(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 5자를 넘으면 예외를 던진다")
    void 이름이_5자를_넘으면_예외를_던진다() {
        //Given
        String name = "aaaaaa";

        //then
        assertThatThrownBy(()->Player.create(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 이름은 객체를 생성한다")
    void 정상적인_이름은_객체를_생성한다() {
        //Given
        String name = "apple";

        //when
        Player player = Player.create(name);

        //then
        assertThat(player.name()).isEqualTo(name);
    }
}
