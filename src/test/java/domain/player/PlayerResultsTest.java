package domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.ladder.Ladder;
import domain.ladder.Line;
import exception.DomainNotFoundException;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerResultsTest {

    @DisplayName("Ladder, Players, Rewards를 입력하면 각 참가자의 실행 결과를 가진 결과를 반환한다")
    @Test
    void createPlayerResults() {
        // given
        Line line = Line.of(List.of(0), 2);
        Ladder ladder = new Ladder(List.of(line));
        Players players = Players.of(List.of("geon", "gun"), Set.of());
        Rewards rewards = new Rewards(List.of("꽝", "당첨"));

        // when
        PlayerResults results = PlayerResults.of(ladder, players, rewards);

        // then
        assertThat(results.findAllResults()).hasSize(2);
    }

    @DisplayName("사용자 이름을 입력하면 해당 결과를 반환한다")
    @Test
    void findResultByName() {
        // given
        Line line = Line.of(List.of(0), 2);
        Ladder ladder = new Ladder(List.of(line));
        Players players = Players.of(List.of("geon", "gun"), Set.of());
        Rewards rewards = new Rewards(List.of("꽝", "당첨"));
        PlayerResults results = PlayerResults.of(ladder, players, rewards);

        // when
        String geonResult = results.findResultByName("geon");
        String gunResult = results.findResultByName("gun");

        // then
        assertThat(geonResult).isEqualTo("당첨");
        assertThat(gunResult).isEqualTo("꽝");
    }

    @DisplayName("사용자 이름을 잘못 입력하면 예외가 발생한다")
    @Test
    void throwExceptionWhenNameNotFound() {
        // given
        Line line = Line.of(List.of(), 2);
        Ladder ladder = new Ladder(List.of(line));
        Players players = Players.of(List.of("geon", "gun"), Set.of());
        Rewards rewards = new Rewards(List.of("꽝", "당첨"));
        PlayerResults results = PlayerResults.of(ladder, players, rewards);

        // when & then
        assertThatThrownBy(() -> results.findResultByName("go"))
                .isInstanceOf(DomainNotFoundException.class);
    }

}
