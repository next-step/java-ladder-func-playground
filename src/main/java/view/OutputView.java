// OutputView.java (REFACTORED)
package view;

// Model import가 모두 삭제되었습니다!
// import Model.*; 

import java.util.List;
// 'Arrays'도 삭제되었습니다. (split, stream 로직이 사라졌으므로)

public class OutputView {

    // 'Bridge' 대신 '완성된 문자열 리스트'를 받습니다.
    public void printBridge(List<String> bridgeLines) {
        // for문이 훨씬 단순해졌습니다.
        for (String line : bridgeLines) {
            System.out.println(line);
        }
    }

    // List<String> 대신 '완성된 한 줄의 문자열'을 받습니다.
    public void printNamesLine(String namesLine) {
        System.out.println(namesLine);
    }

    // printPlayersAndRewards는 printNamesLine으로 대체되거나
    // 역할이 명확해졌습니다.

    // 'Player', 'Reward' 대신 '완성된 결과 문자열 리스트'를 받습니다.
    public void printResults(List<String> resultLines) {
        System.out.println("\n실행 결과");
        for (String line : resultLines) {
            System.out.println(line);
        }
    }

    // printAllResults, printSpecificResults는 
    // printResults(List<String> results) 하나로 통합될 수 있습니다.

    // (참고) '특정 결과'의 에러 메세지 출력 책임은 남겨둘 수 있습니다.
    public void printPlayerNotFoundError(String trimmedName) {
        System.out.println("[ERROR] 존재하지 않는 플레이어 이름입니다: " + trimmedName);
    }

    // --- 질문(Ask) 메서드들은 원래 좋았습니다! ---

    public void askResults() {
        System.out.println("\n결과를 보고 싶은 사람은?");
    }

    public void askPlayers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void askRewards() {
        System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void askLadderHeight() {
        System.out.println("\n사다리의 높이는 몇 개인가요?");
    }
}
