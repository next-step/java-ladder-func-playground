package model;

import constants.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PrizesTest {

    @Test
    @DisplayName("정상적인 상품 리스트로 Prizes를 생성할 수 있다")
    void createPrizesWithValidNames() {
        //given
        List<String> prizes = List.of("꽝", "5000", "꽝", "3000");
        //when & then
        Assertions.assertDoesNotThrow(() -> new Prizes(prizes));
    }

    @Test
    @DisplayName("상품 이름이 5글자를 초과하면 IllegalArgumentException을 던진다")
    void throwsWhenPrizeExceedsFiveCharacters() {
        //given
        List<String> prizes = List.of("꽝", "1000000");
        //when
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Prizes(prizes)
        );
        //then
        Assertions.assertEquals(ErrorMessage.NAME_LONGER_THAN_LIMIT, exception.getMessage());
    }

    @Test
    @DisplayName("getPrizeByIndex는 해당 인덱스의 상품을 반환한다")
    void getPrizeByIndexReturnsPrizeAtIndex() {
        //given
        Prizes prizes = new Prizes(List.of("꽝", "5000", "꽝", "3000"));
        //when
        String prize = prizes.getPrizeByIndex(1);
        //then
        Assertions.assertEquals("5000", prize);
    }

    @Test
    @DisplayName("prizeCount는 상품의 수를 반환한다")
    void prizeCountReturnsNumberOfPrizes() {
        //given
        Prizes prizes = new Prizes(List.of("꽝", "5000", "꽝", "3000"));
        //when
        Integer count = prizes.prizeCount();
        //then
        Assertions.assertEquals(4, count);
    }
}