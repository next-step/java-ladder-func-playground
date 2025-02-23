package domain.ladder;

public class LadderResult {

    private final String result;

    public LadderResult(String result) {
        validateResultBlank(result);
        this.result = result;
    }

    private void validateResultBlank(String result) {
        if (result == null || result.isBlank()) {
            throw new IllegalArgumentException("빈칸을 모두 입력해주세요.");
        }
    }

    public String getResult() {
        return result;
    }
}
