package strategy;

public interface LinkStrategy {
    boolean canLink();

    default int pickRandomRow(int bound) {
        throw new UnsupportedOperationException("랜덤 선택은 지원되지 않는 전략입니다.");
    }
}
