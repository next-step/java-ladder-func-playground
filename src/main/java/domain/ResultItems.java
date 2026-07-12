package domain;

import java.util.List;

public class ResultItems {

    private final List<ResultItem> items;

    public ResultItems(List<ResultItem> items, int expectedSize) {
        validateCount(items, expectedSize);
        this.items = items;
    }

    private void validateCount(List<ResultItem> items, int expectedSize) {
        if (items.size() != expectedSize) {
            throw new IllegalArgumentException("참여자의 수와 실행 결과 개수가 일치하지 않습니다.");
        }
    }

    public int count() {
        return items.size();
    }

    public List<ResultItem> extractItems() {
        return List.copyOf(items);
    }

    public List<String> extractNames() {
        return items.stream()
                .map(ResultItem::getItem)
                .toList();
    }
}
