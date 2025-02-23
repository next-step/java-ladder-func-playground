package domain;

public class LadderDestinationFinder {
    private final Ladder ladder;

    public LadderDestinationFinder(Ladder ladder) {
        this.ladder = ladder;
    }

    public int findDestinationOfLadder(int startPosition){
        int destination = startPosition;
        for(Line line : ladder.getLines()){
            destination = getDestination(line, destination);
        }
        return destination;
    }

    private int getDestination(Line line, int destination) {
        if(destination > 0 && destination -1 < line.getPoints().size() && line.getPoints().get(destination - 1)){
            destination--;
            return destination;
        }
        if(destination >= 0 && destination < line.getPoints().size() && line.getPoints().get(destination)){
            destination++;
        }
        return destination;
    }
}
