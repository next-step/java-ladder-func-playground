package view;

import domain.Size;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static Size readSize() {
        try {
            System.out.println("사다리의 넓이는 몇 개인가요?");
            int width = Integer.parseInt(reader.readLine());
            System.out.println("\n사다리의 높이는 몇 개인가요?");
            int height = Integer.parseInt(reader.readLine());

            validate(width, height);

            return new Size(width, height);
        } catch (IOException e) {
            throw new RuntimeException("입력 중 오류가 발생했습니다.");
        }
    }

    private static void validate(int width, int height) {
        if (width <= 0) {
            throw new IllegalArgumentException("사다리의 넓이는 0보다 커야 합니다.");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("사다리의 높이는 0보다 커야 합니다.");
        }
    }
}
