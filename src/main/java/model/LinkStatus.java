package model;

public enum LinkStatus {
    UNDEFINED(false),
    ABSENT(false),
    PRESENT(true);

    private final boolean present;

    LinkStatus(boolean present) {
        this.present = present;
    }

    public boolean isPresent() {
        return this.present;
    }

}
