package domain.player;

import exception.DomainRuleViolationException;
import java.util.HashSet;
import java.util.List;

public record Players(List<String> names) {

    private static final List<String> FORBIDDEN_PLAYER_NAMES = List.of("all", "q");

    public Players {
        validate(names);
        names = List.copyOf(names);
    }

    public int size() {
        return names.size();
    }

    private static void validate(List<String> names) {
        validateNameFormat(names);
        validateDuplicatedName(names);
        validateNameSize(names);
    }

    private static void validateNameFormat(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new DomainRuleViolationException("참여자는 1명 이상이어야 합니다.");
        }
    }

    private static void validateDuplicatedName(List<String> names) {
        if (names.size() != new HashSet<>(names).size()) {
            throw new DomainRuleViolationException("중복된 이름을 입력할 수 없습니다.");
        }
    }

    private static void validateNameSize(List<String> names) {
        if (names.stream()
                .anyMatch(name -> name.isBlank() || name.length() > 5)) {
            throw new DomainRuleViolationException("이름은 공백이거나 5자보다 길 수 없습니다.");

        }
    }

    private static void validateForbiddenPlayerName(List<String> names) {
        if (names.stream()
                .anyMatch(FORBIDDEN_PLAYER_NAMES::contains)) {
            throw new DomainRuleViolationException("q, all은 참가자 이름으로 사용할 수 없습니다.");
        }
    }
}
