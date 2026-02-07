package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PointTest {

    @DisplayName("Point 생성 시 상태 값이 올바르게 저장된다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void createPoint(boolean hasBridge) {
        Point point = Point.from(hasBridge);
        assertThat(point.hasBridge()).isEqualTo(hasBridge);
    }

    @DisplayName("동일한 상태 값으로 생성 시 같은 인스턴스를 반환한다. (캐싱 확인)")
    @Test
    void pointCaching() {

        Point first = Point.from(true);
        Point second = Point.from(true);

        assertThat(first).isSameAs(second);
    }

}
