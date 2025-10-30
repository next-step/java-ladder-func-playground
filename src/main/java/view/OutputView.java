package view;

import domain.Ladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLadder(List<String> ladderString ) {
        for (String singleRow : ladderString) {
            System.out.println(singleRow);
        }
    }

    public void printPlayersInputMessage() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public void printPrizesInputMessage(){
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public void printRowInput() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }


    public void printAskPlayerMessage(){
        System.out.println("결과를 보고 싶은 사람은?");
    }


    public void printSingleResultMessage(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
        System.out.println();
    }

    public void printAllResultMessage(Map<String, String> resultMap){
        System.out.println("실행 결과");
        for (Map.Entry<String, String> result : resultMap.entrySet()) {
            System.out.println(result.getKey() + " : " + result.getValue());
        }
    }

    public void printInvalidSelectedPlayerMessage(){
        System.out.println("해당 유저가 존재하지 않습니다.");
    }
}
