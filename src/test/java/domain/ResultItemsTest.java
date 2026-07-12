package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResultItemsTest {

    @Test
    @DisplayName("정상적인 결과 목록으로 생성된다.")
    void create() {
        List<ResultItem> items = List.of(new ResultItem("1등"), new ResultItem("2등"), new ResultItem("꽝"));
        ResultItems resultItems = new ResultItems(items, 3);

        assertEquals(3, resultItems.count());
    }

    @Test
    @DisplayName("결과 개수가 예상 개수와 일치하지 않으면 예외가 발생해야 한다.")
    void sizeMismatchThrowsException() {
        List<ResultItem> items = List.of(new ResultItem("1등"), new ResultItem("꽝"));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new ResultItems(items, 3);
        });
        assertEquals("참여자의 수와 실행 결과 개수가 일치하지 않습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("결과 목록의 값을 정확히 추출한다.")
    void extractNames() {
        List<ResultItem> items = List.of(new ResultItem("1등"), new ResultItem("2등"), new ResultItem("꽝"));
        ResultItems resultItems = new ResultItems(items, 3);

        List<String> names = resultItems.extractNames();
        assertEquals(List.of("1등", "2등", "꽝"), names);
    }

    @Test
    @DisplayName("결과 객체 목록을 정확히 반환한다.")
    void extractItems() {
        List<ResultItem> items = List.of(new ResultItem("1등"), new ResultItem("2등"), new ResultItem("꽝"));
        ResultItems resultItems = new ResultItems(items, 3);

        List<ResultItem> extractedItems = resultItems.extractItems();
        assertEquals(3, extractedItems.size());
        assertEquals(items, extractedItems);

        assertThrows(UnsupportedOperationException.class, () -> {
            extractedItems.add(new ResultItem("4등"));
        });
    }
}
