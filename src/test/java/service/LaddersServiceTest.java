package service;

import static org.assertj.core.api.Assertions.assertThat;

import domain.CountOfLadders;
import domain.Height;
import domain.Ladders;
import domain.RungsBuilder;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LaddersServiceTest {

    class TestRungsBuilder implements RungsBuilder {

        @Override
        public List<Boolean> buildAndGetRungsStatus(List<Boolean> prevRungsStatus) {
            return Arrays.asList(false, false, false, false, false);
        }

        @Override
        public List<Boolean> buildTemporaryRungsStatus(int height) {
            return Arrays.asList(true,false, true, false, true);
        }
    }

    @Test
    @DisplayName("createLadders()에선 RungsBuilder로 Ladder를 만들고 이를 활용해 Ladders 객체를 만든다.")
    void test() {
        // given
        final Height height = new Height(5);
        final CountOfLadders countOfLadders = new CountOfLadders(3);
        final TestRungsBuilder testRungsBuilder = new TestRungsBuilder();
        // when
        final LaddersService laddersService = new LaddersService(testRungsBuilder);
        final Ladders ladders = laddersService.createLadders(countOfLadders, height);
        // then
        assertThat(ladders.getRungsStatusAtLadder())
            .isEqualTo(
                Arrays.asList(
                    Arrays.asList(false, false, false, false, false),
                    Arrays.asList(false, false, false, false, false),
                    Arrays.asList(false, false, false, false, false)
                )
            );
    }
}
