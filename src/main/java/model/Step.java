package model;

public class Step {
    private final boolean isBlank;

    public Step(boolean isBlank){
        this.isBlank = isBlank;
    }

    public boolean isBlank() {
        return isBlank;
    }

    @Override
    public String toString() {
        if (this.isBlank) {
            return "     ";
        }

        return "-----";
    }
}
