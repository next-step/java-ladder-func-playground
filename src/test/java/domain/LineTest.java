package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.Line.*;
import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("한 line을 적절하게 생성한다")
    void 한_Line을_적절하게_생성한다() {
        //given
        FixedBooleanGenerator fixedBooleanGenerator = new FixedBooleanGenerator(CONNECTED, NOT_CONNECTED, CONNECTED);

        //when
        Line line = create(fixedBooleanGenerator, 4);

        //then
        assertThat(line.getPoints()).containsExactly(CONNECTED, NOT_CONNECTED, CONNECTED);
    }

    @Test
    @DisplayName("앞이 연결되어 있으면 다음 연결은 NOT CONNECTED가 된다")
    void 앞이_연결되어_있으면_다음_연결은_NOT_CONNECTED가_된다() {
        //given
        FixedBooleanGenerator fixedBooleanGenerator = new FixedBooleanGenerator(CONNECTED, CONNECTED);

        //when
        Line line = create(fixedBooleanGenerator, 3);

        //then
        assertThat(line.getPoints()).containsExactly(CONNECTED, NOT_CONNECTED);
    }

    @Test
    @DisplayName("왼쪽과 연결되어 있으면 왼쪽으로 움직인다")
    void 왼쪽과_연결되어_있으면_왼쪽으로_움직인다() {
        //given
        FixedBooleanGenerator fixedBooleanGenerator = new FixedBooleanGenerator(CONNECTED, NOT_CONNECTED);
        Line line = create(fixedBooleanGenerator, 3);

        //when
        int movedPosition = line.Move(1);

        //then
        assertThat(movedPosition).isEqualTo(0);
    }

    @Test
    @DisplayName("오른쪽과 연결되어 있으면 오른쪽으로 움직인다")
    void 오른쪽과_연결되어_있으면_오른쪽으로_움직인다() {
        //given
        FixedBooleanGenerator fixedBooleanGenerator = new FixedBooleanGenerator(NOT_CONNECTED, CONNECTED);
        Line line = create(fixedBooleanGenerator, 3);

        //when
        int movedPosition = line.Move(1);

        //then
        assertThat(movedPosition).isEqualTo(2);
    }

    @Test
    @DisplayName("연결되어있지 않으면 내려온다")
    void 연결되어있지_않으면_내려온다() {
        //given
        FixedBooleanGenerator fixedBooleanGenerator = new FixedBooleanGenerator(NOT_CONNECTED, NOT_CONNECTED);
        Line line = create(fixedBooleanGenerator, 3);

        //when
        int movedPosition = line.Move(1);

        //then
        assertThat(movedPosition).isEqualTo(1);
    }

    @Test
    @DisplayName("플레이어의 수가 1보다 작으면 예외를 던진다")
    void 플레이어의_수가_1보다_작으면_예외를_던진다() {
        //given
        FixedBooleanGenerator fixedBooleanGenerator = new FixedBooleanGenerator(NOT_CONNECTED, NOT_CONNECTED);

        //then
        assertThatThrownBy(() -> Line.create(fixedBooleanGenerator, -1))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("BooleanGenerator이 null이면 예외를 던진다")
    void BooleanGenerator이_null이면_예외를_던진다() {
        //given
        FixedBooleanGenerator fixedBooleanGenerator = null;

        //then
        assertThatThrownBy(() -> Line.create(fixedBooleanGenerator, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
