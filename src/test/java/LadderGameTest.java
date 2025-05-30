import domain.Ladder;
import domain.Line;
import domain.Names;
import domain.Results;
import domain.LadderGame;
import domain.Result;
import domain.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderGameTest {
    @Test
    @DisplayName("참가자 한명 게임 결과 조회")
    void playForSpecificPlayer() {

    Names names = Names.from("홍길동,김철수");
    Results results = Results.from("당첨,꽝");
    Line line = new Line(Arrays.asList(false));
    Ladder ladder = new Ladder(Arrays.asList(line));
    LadderGame game = new LadderGame(names, results, ladder);

    Result result = game.play(new Name("홍길동"));

    assertThat(result.getValue()).isEqualTo("당첨");
}

    @Test
    @DisplayName("존재하지 않는 참가자로 게임 실행시 예외 발생")
    void playWithNonExistentPlayer() {
        Names names = Names.from("홍길동,김철수");
        Results results = Results.from("당첨,꽝");
        Line line = new Line(Arrays.asList(false));
        Ladder ladder = new Ladder(Arrays.asList(line));
        LadderGame game = new LadderGame(names, results, ladder);

        Exception e = assertThrows(Exception.class, () -> {
            game.play(new Name("처니정"));
        });
    }

    @Test
    @DisplayName("모든 참가자의 게임 결과 조회")
    void playAll() {
        Names names = Names.from("홍길동,김철수");
        Results results = Results.from("당첨,꽝");
        Line line = new Line(Arrays.asList(false));
        Ladder ladder = new Ladder(Arrays.asList(line));
        LadderGame game = new LadderGame(names, results, ladder);

        Map<Name, Result> allResults = game.playAll();

        assertThat(allResults.get(new Name("홍길동")).getValue()).isEqualTo("당첨");
        assertThat(allResults.get(new Name("김철수")).getValue()).isEqualTo("꽝");
    }
}
