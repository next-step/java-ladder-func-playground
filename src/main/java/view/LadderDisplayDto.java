package view;

import java.util.List;

public record LadderDisplayDto(
        List<String> playerNames,
        List<List<Boolean>> lines,
        List<String> rewardNames
) {

}