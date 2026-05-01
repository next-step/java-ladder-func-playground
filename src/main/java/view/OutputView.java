package view;

import constants.ScriptConstants;
import dto.GameResultDto;

import java.util.List;

public class OutputView {

    public void printSingleString(String output) {
        System.out.println(output);
    }

    public void printFullLadderInGame(String output) {
        this.printSingleString(output);
    }

    public void printPlayerResult(GameResultDto gameResultDto) {
        System.out.println(ScriptConstants.RESULT_HEADER);
        System.out.println(gameResultDto.prizeEntry());
    }

    public void printAllPlayerResult(List<GameResultDto> gameResultDtoList) {
        System.out.println(ScriptConstants.RESULT_HEADER);
        for (GameResultDto gameResultDto : gameResultDtoList) {
            System.out.println(gameResultDto.toString());
        }
    }
}
