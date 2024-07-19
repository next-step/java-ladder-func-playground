public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        int width = inputHandler.askWidth();
        int height = inputHandler.askHeight();

        Ladder ladder = new Ladder(width, height);

        OutputHandler outputHandler = new OutputHandler();
        outputHandler.printLadder(ladder);
    }
}
