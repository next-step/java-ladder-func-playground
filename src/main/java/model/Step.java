package model;

public class Step {
    private final boolean isBlank;

    Step(boolean isBlank){
        this.isBlank = isBlank;
    }

    public boolean isBlank() {
        return isBlank;
    }
}
