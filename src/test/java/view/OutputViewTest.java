package view;

import Model.LadderResult;
import Model.Player;
import Model.Rewards;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    private Player createTestPlayer() {
        return new Player(Arrays.asList("pobi", "crong", "honux"));
    }

    private Rewards createTestRewards() {
        return new Rewards(Arrays.asList("꽝", "5000", "꽝"));
    }

    private LadderResult createTestLadderResult() {
        Map<Integer, Integer> resultMap = new HashMap<>();
        resultMap.put(0, 1); // pobi -> 5000
        resultMap.put(1, 2); // crong -> 꽝
        resultMap.put(2, 0); // honux -> 꽝
        return new LadderResult(resultMap);
    }

    @Test
    @DisplayName("'all' 입력 시 모든 결과를 출력한다")
    void printAllResultsTest() {
        // given
        OutputView outputView = new OutputView();
        Player players = createTestPlayer();
        Rewards rewards = createTestRewards();
        LadderResult ladderResult = createTestLadderResult();

        // when
        outputView.printAllResults(players, rewards, ladderResult);

        // then
        String expectedOutput = "pobi : 5000" + System.lineSeparator() +
                "crong : 꽝" + System.lineSeparator() +
                "honux : 꽝" + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("특정 플레이어 한 명의 결과를 출력한다")
    void printSinglePlayerResult() {
        // given
        OutputView outputView = new OutputView();
        Player players = createTestPlayer();
        Rewards rewards = createTestRewards();
        LadderResult ladderResult = createTestLadderResult();

        // when
        outputView.printSpecificResults(players, rewards, ladderResult, "pobi");

        // then
        String expectedOutput = "pobi : 5000" + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("여러 명의 결과를 쉼표로 구분하여 출력한다")
    void printMultiplePlayerResults() {
        // given
        OutputView outputView = new OutputView();
        Player players = createTestPlayer();
        Rewards rewards = createTestRewards();
        LadderResult ladderResult = createTestLadderResult();

        // when
        outputView.printSpecificResults(players, rewards, ladderResult, "pobi,honux");

        // then
        String expectedOutput = "pobi : 5000" + System.lineSeparator() +
                "honux : 꽝" + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("입력값에 공백이 있어도 정상 처리한다")
    void printResultWithWhitespace() {
        // given
        OutputView outputView = new OutputView();
        Player players = createTestPlayer();
        Rewards rewards = createTestRewards();
        LadderResult ladderResult = createTestLadderResult();

        // when
        outputView.printSpecificResults(players, rewards, ladderResult, "  crong, honux  ");

        // then
        String expectedOutput = "crong : 꽝" + System.lineSeparator() +
                "honux : 꽝" + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("존재하지 않는 플레이어 이름 입력 시 에러 메시지를 출력한다")
    void printResultForInvalidPlayer() {
        // given
        OutputView outputView = new OutputView();
        Player players = createTestPlayer();
        Rewards rewards = createTestRewards();
        LadderResult ladderResult = createTestLadderResult();

        // when
        outputView.printSpecificResults(players, rewards, ladderResult, "unknown");

        // then
        String expectedOutput = "[ERROR] 존재하지 않는 플레이어 이름입니다: unknown" + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
}
