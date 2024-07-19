import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    };

    public int askWidth() {
        System.out.println("사다리의 넓이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public int askHeight() {
        System.out.println("사다리의 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
