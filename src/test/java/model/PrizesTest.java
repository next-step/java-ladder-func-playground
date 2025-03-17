package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

public class PrizesTest {

    @Test
    @DisplayName("유효한 값이면 Prizes 객체를 생성하는지 검증한다.")
    public void shouldCreatePrizesWithValidValues() {
        List<String> player = List.of("Gold", "nana", "Broze");
        List<String> prize = List.of("꽝", "3000", "5000");
        Players players = new Players(player);

        Prizes prizes = Prizes.form(prize, players);

        assertThat(prizes.getPrize()).containsExactly("꽝", "3000", "5000");
    }

    @Test
    @DisplayName("실행결과 개수와 참가자의 수가 다르면 예외를 발생시키는지 검증한다.")
    public void shouldThrowExceptionWhenPrizeSizeDoesNotMatchPlayersSize() {
        List<String> player = List.of("Gold", "nana");
        List<String> prize = List.of("꽝", "3000", "5000");
        Players players = new Players(player);

        assertThatThrownBy(() -> Prizes.form(prize, players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행결과 개수와 참가자의 수는 동일해야 합니다.");
    }

    @Test
    @DisplayName("결과가 비어있으면 예외를 발생시키는지 검증한다.")
    public void shouldCreateEmptyPrizesWhenEmptyResults() {
        List<String> player = List.of("Gold", "nana");
        List<String> prize = List.of();
        Players players = new Players(player);

        assertThatThrownBy(() -> Prizes.form(prize, players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("실행결과 개수와 참가자의 수는 동일해야 합니다.");
    }
}
