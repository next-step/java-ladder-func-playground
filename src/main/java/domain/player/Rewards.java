package domain.player;

import exception.DomainRuleViolationException;
import java.util.List;

public record Rewards(List<String> values) {

    public Rewards {
        validate(values);
        values = List.copyOf(values);
    }

    public int size() {
        return values.size();
    }

    private static void validate(List<String> values) {
        validateRewardsCount(values);
        validateRewardsFormat(values);
    }


    private static void validateRewardsCount(List<String> values) {
        if (values == null || values.isEmpty()) {
            throw new DomainRuleViolationException("실행 결과는 1개 이상이어야 합니다.");
        }
    }

    private static void validateRewardsFormat(List<String> values) {
        if (values.stream().anyMatch(String::isBlank)) {
            throw new DomainRuleViolationException("실행 결과는 공백일 수 없습니다.");
        }
    }
}
