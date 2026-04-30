package model;

import constants.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PlayersTest {

    @Test
    @DisplayName("정상적인 이름 리스트로 Players를 생성할 수 있다")
    void createPlayersWithValidNames() {
        //given
        List<String> names = List.of("neo", "brown", "brie", "tomy");
        //when & then
        Assertions.assertDoesNotThrow(() -> new Players(names));
    }

    @Test
    @DisplayName("이름이 5글자를 초과하면 IllegalArgumentException을 던진다")
    void throwsWhenNameExceedsFiveCharacters() {
        //given
        List<String> names = List.of("neo", "longname");
        //when
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Players(names)
        );
        //then
        Assertions.assertEquals(ErrorMessage.NAME_LONGER_THAN_LIMIT, exception.getMessage());
    }

    @Test
    @DisplayName("중복된 이름이 존재하면 IllegalArgumentException을 던진다")
    void throwsWhenDuplicateNamesExist() {
        //given
        List<String> names = List.of("neo", "neo", "brie");
        //when
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Players(names)
        );
        //then
        Assertions.assertEquals(ErrorMessage.DUPLICATE_NAMES, exception.getMessage());
    }

    @Test
    @DisplayName("calculateIndexOfPlayerName은 일치하는 이름의 인덱스를 반환한다")
    void calculateIndexOfPlayerNameReturnsMatchingIndex() {
        //given
        Players players = new Players(List.of("neo", "brown", "brie", "tomy"));
        //when
        Integer index = players.calculateIndexOfPlayerName("brie");
        //then
        Assertions.assertEquals(2, index);
    }

    @Test
    @DisplayName("calculateIndexOfPlayerName은 존재하지 않는 이름이 들어오면 IllegalArgumentException을 던진다")
    void calculateIndexOfPlayerNameThrowsWhenNameNotPresent() {
        //given
        Players players = new Players(List.of("neo", "brown"));
        //when
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> players.calculateIndexOfPlayerName("ghost")
        );
        //then
        Assertions.assertEquals(ErrorMessage.ENTRY_NOT_PRESENT, exception.getMessage());
    }

    @Test
    @DisplayName("getPlayerNameyByIndex는 해당 인덱스의 이름을 반환한다")
    void getPlayerNameByIndexReturnsNameAtIndex() {
        //given
        Players players = new Players(List.of("neo", "brown", "brie", "tomy"));
        //when
        String name = players.getPlayerNameByIndex(1);
        //then
        Assertions.assertEquals("brown", name);
    }

    @Test
    @DisplayName("playerCount는 플레이어의 수를 반환한다")
    void playerCountReturnsNumberOfPlayers() {
        //given
        Players players = new Players(List.of("neo", "brown", "brie", "tomy"));
        //when
        Integer count = players.playerCount();
        //then
        Assertions.assertEquals(4, count);
    }
}
