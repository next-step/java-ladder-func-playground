package model.result;

public class Prize {
    private final String prizeType;

    public Prize(String prizeType) {
        validatePrize(prizeType);
        this.prizeType = prizeType;
    }

    private void validatePrize(String prizeType) {
        if (prizeType == null|| prizeType.isEmpty()) {
            throw new IllegalArgumentException(String.format("결과는 빈칸일 수 없습니다."));
        }
    }

    public String getValue() {
        return this.prizeType;
    }
}
