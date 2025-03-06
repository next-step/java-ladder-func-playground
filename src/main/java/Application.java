import model.Ladder;

public class Application {
    public static void main(String[] args) {
        int width = 4;
        int height = 4;

        Ladder ladder = Ladder.of(height, width);
        ladder.print();
    }
}