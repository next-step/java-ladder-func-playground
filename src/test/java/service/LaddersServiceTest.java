package service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import domain.Ladders;
import domain.RungsBuilder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LaddersServiceTest {

    private static final int initialPosition = 0;
    private static final Set<Integer> addPositions = new HashSet<>(Set.of(1, 2, 3));


    static class TestRungsBuilder implements RungsBuilder {

        @Override
        public int getPositionOfRung() {
            return initialPosition;
        }

        @Override
        public Set<Integer> getPositionsOfRungs() {
            return addPositions;
        }
    }

    @Test
    @DisplayName("RungsBuilder를 사용하여 '초기 가로줄의 위치'와 '새로 만들 가로줄의 위치들'을 받을 수 있다.")
    void rungsBuilderTest() {
        // given
        final TestRungsBuilder testRungsBuilder = new TestRungsBuilder();
        final LaddersService laddersService = new LaddersService(testRungsBuilder);

        int countOfLadders = 1;
        int height = 4;
        // when
        final Ladders ladders = laddersService.createLadders(countOfLadders, height);
        // then
        final List<Set<Integer>> allRungsPositionAtLadder = ladders.getAllRungsPositionAtLadder();
        assertAll(
            () -> assertThat(allRungsPositionAtLadder.size()).isEqualTo(countOfLadders),
            () -> assertThat(allRungsPositionAtLadder.get(0)).contains(initialPosition),
            () -> assertThat(allRungsPositionAtLadder.get(0)).containsAll(addPositions)
        );
    }


}
