package domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.DomainRuleViolationException;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

    @DisplayName("참여자 수가 1명보다 작으면 예외가 발생한다")
    @Test
    void throwExceptionWhenPlayersCountLessThanOne() {
        // given
        List<String> emptyNames = List.of();

        // when & then
        assertThatThrownBy(() -> Players.of(emptyNames, Set.of()))
                .isInstanceOf(DomainRuleViolationException.class);
    }

    @DisplayName("이름이 공백이면 예외가 발생한다")
    @Test
    void throwExceptionWhenNameIsBlank() {
        // given
        List<String> names = List.of("geon", "  ");

        // when & then
        assertThatThrownBy(() -> Players.of(names, Set.of()))
                .isInstanceOf(DomainRuleViolationException.class);
    }

    @DisplayName("이름이 5자보다 길면 예외가 발생한다")
    @Test
    void throwExceptionWhenNameLengthGreaterThanFive() {
        // given
        List<String> names = List.of("geongo", "gun");

        // when & then
        assertThatThrownBy(() -> Players.of(names, Set.of()))
                .isInstanceOf(DomainRuleViolationException.class);
    }

    @DisplayName("참여자 이름으로 q, all이 입력되면 예외가 발생한다")
    @Test
    void throwExceptionWhenForbiddenNameUsed() {
        // given
        List<String> names = List.of("geon", "all");
        Set<String> forbiddenNames = Set.of("q", "all");

        // when & then
        assertThatThrownBy(() -> Players.of(names, forbiddenNames))
                .isInstanceOf(DomainRuleViolationException.class);
    }

    @DisplayName("중복된 이름이 입력되면 예외가 발생한다")
    @Test
    void throwExceptionWhenDuplicatedName() {
        // given
        List<String> names = List.of("geon", "geon");

        // when & then
        assertThatThrownBy(() -> Players.of(names, Set.of()))
                .isInstanceOf(DomainRuleViolationException.class);
    }

    @DisplayName("올바른 이름으로 Players를 생성한다")
    @Test
    void createPlayers() {
        // given
        List<String> names = List.of("geon", "go", "gg");

        // when
        Players players = Players.of(names, Set.of("q", "all"));

        // then
        assertThat(players.size()).isEqualTo(3);
    }

}
