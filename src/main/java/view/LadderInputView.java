package view;

public class LadderInputView {

    public int inputLadderWidth() {
        System.out.println("사다리의 넓이는 몇 개인가요?");

        return Integer.parseInt(InputView.userInput());
    }

    public int inputLadderHeight() {
        System.out.println("사다리의 높이는 몇 개인가요?");

        return Integer.parseInt(InputView.userInput());
    }
}
