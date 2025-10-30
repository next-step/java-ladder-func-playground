package ladder;

import model.ladder.ConnectionStatus;
import model.ladder.Ladder;
import model.ladder.LadderGame;
import model.ladder.Line;
import model.ladder.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderGameTest {
    private LadderGame predictableLadderGame;

    @BeforeEach
    @DisplayName("테스트를 위한 고정 사다리 생성")
    void setUp() {
        //   0     1     2
        // 0 |-----|     |
        // 1 |     |-----|
        // 2 |-----|     |

        // 0번 라인 (true, false)
        Line line1 = new Line(List.of(
                new Point(ConnectionStatus.CONNECTED),
                new Point(ConnectionStatus.DISCONNECTED)
        ));

        // 1번 라인 (false, true)
        Line line2 = new Line(List.of(
                new Point(ConnectionStatus.DISCONNECTED),
                new Point(ConnectionStatus.CONNECTED)
        ));

        // 2번 라인 (true, false)
        Line line3 = new Line(List.of(
                new Point(ConnectionStatus.CONNECTED),
                new Point(ConnectionStatus.DISCONNECTED)
        ));

        Ladder ladder = new Ladder(List.of(line1, line2, line3));
        this.predictableLadderGame = new LadderGame(ladder);
    }

    @Test
    @DisplayName("0번 플레이어는 2번으로 도착해야 한다")
    void tracePlayer0() {
        assertThat(predictableLadderGame.trace(0)).isEqualTo(2);
    }

    @Test
    @DisplayName("1번 플레이어는 1번으로 도착해야 한다")
    void tracePlayer1() {
        assertThat(predictableLadderGame.trace(1)).isEqualTo(1);
    }

    @Test
    @DisplayName("2번 플레이어는 0번으로 도착해야 한다")
    void tracePlayer2() {
        assertThat(predictableLadderGame.trace(2)).isEqualTo(0);
    }
}
