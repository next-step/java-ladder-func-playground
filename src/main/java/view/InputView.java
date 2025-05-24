package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return readLine();
    }

    public static String readResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return readLine();
    }

    public static int readHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(readLine());
    }

    public static String readQueryName() {
        System.out.println("결과를 보고 싶은 사람은?");
        return readLine();
    }

    private static String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("입력 중 오류가 발생했습니다.");
        }
    }
}
