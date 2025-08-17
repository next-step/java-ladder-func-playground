package model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import exception.CustomException;
import exception.ErrorMessage;

public class PlayerTest {

    @Test
    void 정상적인_형태의_이름으로_플레이어_객체를_생성한다() {
        assertThatCode(() -> new Player("neo"))
            .doesNotThrowAnyException();
    }

    @Test
    void 이름이_널이라면_플레이어_객체_생성_시_예외를_발생한다() {
        assertThatThrownBy(() -> new Player(null))
            .isInstanceOf(CustomException.class)
            .extracting("message")
            .isEqualTo(ErrorMessage.EMPTY_NAME.getMessage());
    }

    @Test
    void 이름이_비어있는_문자열이라면_플레이어_객체_생성_시_예외를_발생한다() {
        assertThatThrownBy(() -> new Player("   "))
            .isInstanceOf(CustomException.class)
            .extracting("message")
            .isEqualTo(ErrorMessage.EMPTY_NAME.getMessage());
    }

    @Test
    void 이름이_5글자를_넘어가면_플레이어_객체_생성_시_예외를_발생한다() {
        String longName = "abcdef";

        assertThatThrownBy(() -> new Player(longName))
            .isInstanceOf(CustomException.class)
            .extracting("message")
            .isEqualTo(ErrorMessage.NAME_LENGTH.getMessage());
    }
}
