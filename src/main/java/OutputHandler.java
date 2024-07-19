public class OutputHandler {
    public void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            System.out.println(line);
        }
    }
}
