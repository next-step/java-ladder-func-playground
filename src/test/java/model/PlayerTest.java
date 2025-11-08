package model;

import Model.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    @DisplayName("플레이어 이름은 쉼표로 구분되어 생성된다")
    void playerNamesAreSplit() {
        // given
        var expected = Arrays.asList("pobi", "crong", "honux");
        String inputNames = "pobi,crong,honux";
        List<String> names = Arrays.asList(inputNames.split(","));

        // when
        Player players = new Player(names);
        List<String> actual = players.getPlayers();

        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }
}
