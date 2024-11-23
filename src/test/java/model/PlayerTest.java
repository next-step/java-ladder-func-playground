package model;

import model.player.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PlayerTest {
    @Test
    void 이름이_5자_이하일_때_오류가_안_발생하는_지_확인(){
            //Given & When & Then
            assertDoesNotThrow(() -> new Player(5,"abcd"));
    }

    @Test
    void 이름이_5자_초과일_때_오류가_발생하는_지_확인() {
        //Given & When & Then
        Assertions.assertThatThrownBy(() -> new Player(5,"abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자 이름이 5자 초과입니다.");
    }
}
