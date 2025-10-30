package result;

import model.result.GameResult;
import model.participant.Player;
import model.result.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    private GameResult gameResult;
    private Player neo;
    private Player brown;
    private Prize prize1;
    private Prize prize2;

    @BeforeEach
    void setUp() {
        gameResult = new GameResult();
        neo = new Player("neo");
        brown = new Player("brown");
        prize1 = new Prize("5000");
        prize2 = new Prize("꽝");

        gameResult.addResult(neo, prize2);
        gameResult.addResult(brown, prize1);
    }

    @Test
    @DisplayName("String 이름으로 Prize 결과를 올바르게 조회한다")
    void getDestinationByName() {
        Prize neoResult = gameResult.getDestination("neo");
        Prize brownResult = gameResult.getDestination("brown");

        assertThat(neoResult).isEqualTo(prize2);
        assertThat(brownResult).isEqualTo(prize1);
    }

    @Test
    @DisplayName("공백이 포함된 이름으로 Prize 결과를 올바르게 조회한다")
    void getDestinationByTrimmedName() {
        String nameWithSpaces = "  neo  ";

        Prize neoResult = gameResult.getDestination(nameWithSpaces);

        assertThat(neoResult).isEqualTo(prize2);
    }

    @Test
    @DisplayName("존재하지 않는 이름으로 조회하면 null을 반환한다")
    void getDestinationForUnknownName() {
        Prize unknownResult = gameResult.getDestination("brie");

        assertThat(unknownResult).isNull();
    }
}
