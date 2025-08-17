package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import exception.CustomException;
import exception.ErrorMessage;

public class PlayersTest {

    @Test
    void 플레이어_리스트가_널이라면_객체_생성_시_예외를_발생한다() {
        assertThatThrownBy(() -> new Players(null))
            .isInstanceOf(CustomException.class)
            .extracting("message")
            .isEqualTo(ErrorMessage.PLAYER_NAMES_EMPTY.getMessage());
    }

    @Test
    void 플레이어_리스트가_비어있다면_객체_생성_시_예외를_발생한다() {
        assertThatThrownBy(() -> new Players(Collections.emptyList()))
            .isInstanceOf(CustomException.class)
            .extracting("message")
            .isEqualTo(ErrorMessage.PLAYER_NAMES_EMPTY.getMessage());
    }

    @Test
    void 정상적인_이름_리스트로_Players_객체를_생성한다() {
        List<String> names = Arrays.asList("neo", "brown", "tommy");
        Players players = new Players(names);

        assertThat(players.size()).isEqualTo(names.size());

        assertThat(players.getPlayers())
            .extracting(Player::getName)
            .containsExactlyElementsOf(names);
    }

    @Test
    void 존재하는_이름으로_indexOf_메소드를_호출하면_올바른_인덱스를_반환한다() {
        List<String> names = Arrays.asList("neo", "brown", "tommy");
        Players players = new Players(names);

        int index = players.indexOf("brown");

        assertThat(index).isEqualTo(1);
    }

    @Test
    void 존재하지_않는_이름으로_indexOf_메소드를_호출하면_예외를_발생한다() {
        List<String> names = Arrays.asList("neo", "brown", "tommy");
        Players players = new Players(names);

        assertThatThrownBy(() -> players.indexOf("alice"))
            .isInstanceOf(CustomException.class)
            .extracting("message")
            .isEqualTo(ErrorMessage.PLAYER_NOT_FOUND.getMessage());
    }
}
