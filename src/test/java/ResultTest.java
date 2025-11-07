import model.Ladder;
import model.LadderGame;
import model.Line;
import model.Participants;
import model.Point;
import model.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("입출력 결과 테스트")
public class ResultTest {

    @Test
    @DisplayName("참여자 이름을 쉼표로 구분하여 List로 변환한다")
    void parseParticipantNames() {
        String input = "neo,brown,brie,tommy";
        List<String> names = Arrays.asList(input.split(","));
        Participants participants = new Participants(names);

        assertEquals(4, participants.size());
        assertEquals("neo", participants.get(0));
        assertEquals("brown", participants.get(1));
        assertEquals("brie", participants.get(2));
        assertEquals("tommy", participants.get(3));
    }

    @Test
    @DisplayName("실행 결과를 쉼표로 구분하여 List로 변환한다")
    void parseResults() {
        String input = "꽝,5000,꽝,3000";
        List<String> values = Arrays.asList(input.split(","));
        Results results = new Results(values);

        assertEquals(4, results.size());
        assertEquals("꽝", results.get(0));
        assertEquals("5000", results.get(1));
        assertEquals("꽝", results.get(2));
        assertEquals("3000", results.get(3));
    }

    @Test
    @DisplayName("존재하지 않는 참여자 이름은 -1 인덱스를 반환한다")
    void nonExistentParticipantReturnsNegativeIndex() {
        Participants participants = new Participants(Arrays.asList("neo", "brown", "brie"));

        int index = participants.indexOf("unknown");

        assertEquals(-1, index);
    }

    @Test
    @DisplayName("참여자 수와 결과 수가 일치하지 않으면 예외가 발생한다")
    void participantAndResultCountMustMatch() {
        List<Point> line = Arrays.asList(new Point(false), new Point(false));
        Ladder ladder = new Ladder(Arrays.asList(new Line(line)));

        Participants participants = new Participants(Arrays.asList("a", "b", "c"));
        Results results = new Results(Arrays.asList("1", "2"));

        LadderGame game = new LadderGame(ladder, 3);

        assertThrows(
                IndexOutOfBoundsException.class, () -> {
                    game.playAll(participants, results);
                });
    }
}

