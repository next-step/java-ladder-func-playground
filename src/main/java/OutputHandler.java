public class OutputHandler {
    public void printLadder(Ladder ladder) {
        System.out.println("실행결과\n");
        for (Line line : ladder.getLines()) {
            System.out.println(line);
        }
    }

    public void printResults(Ladder ladder, int width) {
        for (int i = 0; i < width; i++) {
            int endPosition = ladder.getResult(i);
            System.out.println(i + " -> " + endPosition);
        }
    }
}
