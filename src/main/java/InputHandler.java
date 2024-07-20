import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    };

    public List<Player> askPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        String[] names = input.split(",");
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            players.add(new Player(names[i].trim(), i));
        }
        return players;
    }

    public List<String> askResults(int playerCount) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = scanner.nextLine();
        String[] results = input.split(",");
        if (results.length != playerCount) {
            throw new IllegalArgumentException("참여자 수와 결과 수가 일치하지 않습니다.");
        }
        List<String> resultList = new ArrayList<>();
        for (String result : results) {
            resultList.add(result.trim());
        }
        return resultList;
    }

    public int askWidth() {
        System.out.println("사다리의 넓이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public int askHeight() {
        System.out.println("사다리의 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public String askPlayerName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.next();
    }
}
