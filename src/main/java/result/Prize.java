package result;

public record Prize(String value) {

    public static Prize from(String value) {
        return new Prize(value);
    }
}
