package domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {
    private final String[] prize;

    public LadderResult(String[] prize){
        this.prize = prize;
    }

    public Map<String,String> matchPrize(Map<String,Integer> players){
        return players.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry->prize[entry.getValue()]
                ));
    }

    public List<String> getPrizes(){
        return List.of(prize);
    }

    public int size() {
        return prize.length;
    }
}
