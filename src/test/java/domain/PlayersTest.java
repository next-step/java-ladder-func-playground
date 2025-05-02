package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayersTest {

    @Test
    @DisplayName("문자리스트를 받아서 players를 생성한다")
    void 문자리스트를_받아서_players를_생성한다() {
        //given
        List<String> nameList = List.of("A", "B", "C", "D");

        //when
        Players players = Players.from(nameList);

        //then
        assertThat(players.names()).containsExactly("A", "B", "C", "D");
        assertThat(players.names()).hasSize(4);
    }

    @Test
    @DisplayName("이름이 2개보다 적으면 예외를 반환한다")
    void 이름이_2개보다_적으면_예외를_반환한다() {
        //given
        List<String> nameList = List.of("A");

        //then
        assertThatThrownBy(() -> Players.from(nameList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("인덱스로 이름을 조횐한다")
    void 인덱스로_이름을_조회한다() {
        //when
        Players players = Players.from(List.of("A", "B", "C"));

        //then
        assertThat(players.nameAt(1)).isEqualTo("B");
    }
}
