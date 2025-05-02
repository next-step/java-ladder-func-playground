package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeTest {

    @Test
    @DisplayName("label에 null 값이 들어가면 예외를 던진다")
    void label에_null_값이_들어가면_예외를_던진다() {
        //Given
        String label = null;

        //then
        assertThatThrownBy(()->Prize.create(label))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("label에 빈문자열이 들어가면 예외를 던진다")
    void label에_빈문자열이_들어가면_예외를_던진다() {
        //Given
        String label = " ";

        //then
        assertThatThrownBy(()->Prize.create(label))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("label이 5자를 넘으면 예외를 던진다")
    void label이_5자를_넘으면_예외를_던진다() {
        //Given
        String label = "aaaaaa";

        //then
        assertThatThrownBy(()->Prize.create(label))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 label은 객체를 생성한다")
    void 정상적인_label은_객체를_생성한다() {
        //Given
        String label = "money";

        //when
        Prize prize = Prize.create(label);

        //then
        assertThat(prize.label()).isEqualTo(label);
    }

}
