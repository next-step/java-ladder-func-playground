package result;


import ladder.LadderGame;
import people.People;
import people.Person;

import java.util.LinkedHashMap;
import java.util.Map;

public record LadderResult(Map<Person, Prize> result) {

    public static LadderResult from(People people, Prizes prizes, LadderGame game) {
        Map<Person, Prize> resultMap = new LinkedHashMap<>();

        for (int start = 0; start < people.size(); start++) {
            Person person = people.personAt(start);
            int endIndex = game.play(start);
            Prize prize = prizes.prizeAt(endIndex);
            resultMap.put(person, prize);
        }

        return new LadderResult(resultMap);
    }

    public Prize findByName(String name) {
        return result.keySet().stream()
                .filter(person -> person.isSameName(name))
                .map(result::get)
                .findFirst()
                .orElse(null);
    }

    public Map<String, String> toNamePrizeMap() {
        Map<String, String> map = new LinkedHashMap<>();
        for (Map.Entry<Person, Prize> entry : result.entrySet()) {
            map.put(entry.getKey().name(), entry.getValue().value());
        }
        return map;
    }
}