package view;

public class LadderInputView {

    public String inputParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return InputView.userInput();
    }

    public String inputLadderResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        return InputView.userInput();
    }

    public int inputLadderHeight() {
        System.out.println("사다리의 높이는 몇 개인가요?");

        return Integer.parseInt(InputView.userInput());
    }

    public String inputResultViewer() {
        System.out.println("결과를 보고 싶은 사람은?");

        return InputView.userInput();
    }
}
