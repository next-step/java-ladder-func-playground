package domain.player;

import exception.DomainRuleViolationException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Players {

    private final List<String> names;

    private Players(List<String> names) {
        this.names = names;
    }

    public static Players of(List<String> names, Set<String> forbiddenPlayerNames) {
        validate(names, forbiddenPlayerNames);
        return new Players(List.copyOf(names));
    }

    public int size() {
        return names.size();
    }

    public List<String> getNames() {
        return names;
    }

    private static void validate(List<String> names, Set<String> forbiddenPlayerNames) {
        validateNameFormat(names);
        validateDuplicatedName(names);
        validateNameSize(names);
        validateForbiddenPlayerName(names, forbiddenPlayerNames);
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

    private static void validateForbiddenPlayerName(List<String> names,
            Set<String> forbiddenPlayerNames) {
        if (names.stream()
                .anyMatch(forbiddenPlayerNames::contains)) {
            throw new DomainRuleViolationException("q, all은 참가자 이름으로 사용할 수 없습니다.");
        }
    }
}
