package domain.participant;

public class Participant {

    private final Name name;
    private final int startPoint;

    public Participant(String name, int startPoint) {
        this.name = new Name(name);
        this.startPoint = startPoint;
    }

    public String getName() {
        return name.getName();
    }

    public int getStartPoint() {
        return startPoint;
    }
}
