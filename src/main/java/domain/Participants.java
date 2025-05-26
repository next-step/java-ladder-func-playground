package domain;

import java.util.List;

public class Participants {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String RESERVED_KEYWORD = "all";

    private static final String ERROR_NO_PARTICIPANTS = "[ERROR] 참여자는 한 명 이상이어야 합니다.";
    private static final String ERROR_NAME_TOO_LONG = "[ERROR] 참여자 이름은 5자 이하만 가능합니다: ";
    private static final String ERROR_RESERVED_NAME = "[ERROR] 'all'은 사용할 수 없는 이름입니다.";

    private final List<String> names;

    private Participants(List<String> names) {
        this.names = names;
    }

    public static Participants of(List<String> names) {
        validate(names);
        return new Participants(names);
    }

    public List<String> getNames() {
        return names;
    }

    public int getCount() {
        return names.size();
    }

    private static void validate(List<String> names) {
        validateNotEmpty(names);
        validateNameLength(names);
        validateReservedKeyword(names);
    }

    private static void validateNotEmpty(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(ERROR_NO_PARTICIPANTS);
        }
    }

    private static void validateNameLength(List<String> names) {
        names.stream()
                .filter(name -> name.length() > MAX_NAME_LENGTH)
                .findFirst()
                .ifPresent(name -> {
                    throw new IllegalArgumentException(ERROR_NAME_TOO_LONG + name);
                });
    }

    private static void validateReservedKeyword(List<String> names) {
        if (names.contains(RESERVED_KEYWORD)) {
            throw new IllegalArgumentException(ERROR_RESERVED_NAME);
        }
    }
}
