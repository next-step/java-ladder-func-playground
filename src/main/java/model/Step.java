package model;

public record Step(boolean isBlank) {

    @Override
    public String toString() {
        if (this.isBlank) {
            return "     ";
        }

        return "-----";
    }
}
