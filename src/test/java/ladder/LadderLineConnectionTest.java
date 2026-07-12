package ladder;

import domain.ladder.LadderLineConnection;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("사다리 연결 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LadderLineConnectionTest {

    @Test
    @DisplayName("연결 유무에 따라 사다리의 모양이 바뀐다.")
    public void 연결_유무에_따라_사다리의_모양이_바뀐다() {
        //given
        final String expected1 = "|-----";
        final String expected2 = "|     ";
        final boolean isConnected1 = true;
        final boolean isConnected2 = false;

        //when, then
        Assertions.assertAll(
                () -> assertEquals(LadderLineConnection.of(isConnected1).getLadderConnectionFormat(), expected1),
                () -> assertEquals(LadderLineConnection.of(isConnected2).getLadderConnectionFormat(), expected2)
        );
    }
}
