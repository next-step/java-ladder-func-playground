package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.LadderPrinter;

public class LadderPrinterTest {

    LadderGame ladderGame;

    @BeforeEach
    @DisplayName("사다리 게임 초기화")
    void setUp() {
        // 고정된 전략으로 테스트 (항상 오른쪽으로 연결됨)
        RandomStrategy fixedStrategy = () -> true;
        // 가로 5, 높이 3, 전략 주입
        ladderGame = LadderGame.of(5, new LadderHeight(3), fixedStrategy);
    }

    @Test
    @DisplayName("전체 사다리 출력 테스트")
    void printLadderStructure() {
        System.out.println("\n=== Ladder Structure ===");
        LadderPrinter.printLadder(ladderGame);
    }

    // 출력 로직 오류
    // 1. line 겹침
}
