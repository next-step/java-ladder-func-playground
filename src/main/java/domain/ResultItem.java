package domain;

public class ResultItem {

    private final String item;

    public ResultItem(String item) {
        validate(item);
        this.item = item;
    }

    private void validate(String item) {
        if (item.isEmpty()) {
            throw new IllegalArgumentException("실행 결과 값은 필수 입력 값입니다.");
        }
    }

    public String getItem() {
        return item;
    }
}
