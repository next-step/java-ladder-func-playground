package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameResult {

    private final Map<Player, ResultItem> results = new LinkedHashMap<>();

    public LadderGameResult(Players players, ResultItems resultItems, LadderGame ladder) {
        List<Player> playerList = players.extractPlayers();
        List<ResultItem> resultList = resultItems.extractItems();

        for (int i = 0; i < playerList.size(); i++) {
            int finalPosition = ladder.getFinalPosition(i);

            if (finalPosition >= resultItems.count()) {
                throw new IllegalArgumentException("최종 위치가 결과의 범위를 벗어났습니다.");
            }

            results.put(playerList.get(i), resultList.get(finalPosition));
        }
    }

    public ResultItem getSingleResultFor(Player player) {
        if (!results.containsKey(player)) {
            throw new IllegalArgumentException("존재하지 않는 플레이어입니다: " + player.getName());
        }
        return results.get(player);
    }

    public Map<Player, ResultItem> getAllResults() {
        return results.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
