package ladder;

import model.ladder.Ladder;
import model.ladder.generator.RandomConnectionGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {

    private final RandomConnectionGenerator randomConnectionGenerator = new RandomConnectionGenerator();

    @Test
    @DisplayName("사다리 높이가 0이하이면 예외가 발생한다")
    void validateLadderHeight(){
        int width = 5;
        int height = 0;

        assertThrows(IllegalArgumentException.class, () -> new Ladder(width, height, randomConnectionGenerator));
    }

    @Test
    @DisplayName("사다리 폭이 1이하이면 예외가 발생한다")
    void validateLadderWidth(){
        int width = 0;
        int height = 5;

        assertThrows(IllegalArgumentException.class, () -> new Ladder(width, height, randomConnectionGenerator));
    }

    @Test
    @DisplayName("사다리 폭과 높이가 정상이면 객체가 잘 생성된다")
    void createLadderSuccessfully(){
        int width = 5;
        int height = 5;
        Ladder ladder = new Ladder(width, height, randomConnectionGenerator);

        assertThat(ladder).isNotNull();
        assertThat(ladder.getHeight()).isEqualTo(height);
        assertThat(ladder.getLine(0).getPointCount()).isEqualTo(width - 1);
    }
}
