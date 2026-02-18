package domain.player;

import exception.DomainRuleViolationException;
import java.util.List;

public final class Rewards {

    private final List<String> values;

    public Rewards(List<String> values) {
        validate(values);
        this.values = List.copyOf(values);
    }

    public int size() {
        return values.size();
    }

    public List<String> getValues() {
        return values;
    }

    private void validate(List<String> values) {
        validateRewardsCount(values);
        validateRewardsFormat(values);
    }

    private void validateRewardsCount(List<String> values) {
        if (values == null || values.isEmpty()) {
            throw new DomainRuleViolationException("실행 결과는 1개 이상이어야 합니다.");
        }
    }

    private void validateRewardsFormat(List<String> values) {
        if (values.stream().anyMatch(String::isBlank)) {
            throw new DomainRuleViolationException("실행 결과는 공백일 수 없습니다.");
        }
    }
}
