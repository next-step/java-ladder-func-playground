package people;

public record Person(String name) {
    private static final int MAX_NAME_LENGTH = 5;

    public Person {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }

        if (name.length() >  MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "이름의 길이는 %d 이하여야 합니다.".formatted(MAX_NAME_LENGTH)
            );
        }
    }

    public static Person from(String name) {
        return new Person(name);
    }

    public boolean isSameName(String target) {
        return this.name.equals(target);
    }
}
