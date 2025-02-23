package domain.participant;

import static constant.LadderConstant.RESERVED_WORD;

public class Name {

    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateBlankName(name);
        validateNameLength(name);
        validateReservedName(name);
    }

    private void validateBlankName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름을 작성해주세요.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름을 1~%d자 사이로 입력해주세요.", MAX_NAME_LENGTH));
        }
    }

    private void validateReservedName(String name) {
        if (RESERVED_WORD.equals(name)) {
            throw new IllegalArgumentException(String.format("%s는 현재 지시어로 사용할 수 없습니다. 다른 이름을 입력 해주세요.", name));
        }
    }

    public String getName() {
        return name;
    }
}
