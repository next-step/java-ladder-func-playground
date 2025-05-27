import domain.Line;
import domain.Names;
import domain.Results;
import domain.Ladder;
import domain.LadderGame;
import domain.Name;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class LadderGameTest {

        @Test
        @DisplayName("2명, 높이 1로 사다리 게임 실행")
        void playWithMinimumPlayersAndHeight() {
            Names names = Names.from("A,B");
            Results results = Results.from("당첨,꽝");

            List<Boolean> steps = Arrays.asList(false);
            Line line = new Line(steps);
            Ladder ladder = new Ladder(Arrays.asList(line));

            LadderGame game = new LadderGame(names, results, ladder);

            Results.Result resultA = game.play(new Name("A"));
            Results.Result resultB = game.play(new Name("B"));

            assertEquals("당첨", resultA.getValue());
            assertEquals("꽝", resultB.getValue());

            Map<Name, Results.Result> allResults = game.playAll();
            assertEquals(2, allResults.size());
            assertEquals("당첨", allResults.get(new Name("A")).getValue());
            assertEquals("꽝", allResults.get(new Name("B")).getValue());
        }

        @Test
        @DisplayName("최대 이름 길이와 연결된 사다리로 위치 변경 테스트")
        void playWithMaxNameLengthAndConnectedLadder() {
            Names names = Names.from("12345,ABCDE,가나다라마");
            Results results = Results.from("1등,2등,3등");

            List<Boolean> steps1 = Arrays.asList(true, false);
            List<Boolean> steps2 = Arrays.asList(false, true);

            Line line1 = new Line(steps1);
            Line line2 = new Line(steps2);
            Ladder ladder = new Ladder(Arrays.asList(line1, line2));

            LadderGame game = new LadderGame(names, results, ladder);

            Results.Result result1 = game.play(new Name("12345"));
            assertEquals("3등", result1.getValue());

            Results.Result result2 = game.play(new Name("ABCDE"));
            assertEquals("1등", result2.getValue());

            Results.Result result3 = game.play(new Name("가나다라마"));
            assertEquals("2등", result3.getValue());
        }

        @Test
        @DisplayName("존재하지 않는 이름으로 게임시 예외 발생")
        void playWithNonExistentName() {
            Names names = Names.from("A,B");
            Results results = Results.from("당첨,꽝");
            List<Boolean> steps = Arrays.asList(false);
            Ladder ladder = new Ladder(Arrays.asList(new Line(steps)));

            LadderGame game = new LadderGame(names, results, ladder);

            assertThrows(Exception.class, () -> {
                game.play(new Name("C"));
            });
        }
    }
