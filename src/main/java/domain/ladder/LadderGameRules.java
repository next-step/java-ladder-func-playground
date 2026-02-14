package domain.ladder;

import domain.player.Players;
import domain.player.Rewards;
import exception.DomainRuleViolationException;

public final class LadderGameRules {

    private LadderGameRules() {
    }

    public static void validateMatch(Players players, Rewards rewards) {
        if (players.size() != rewards.size()) {
            throw new DomainRuleViolationException("참여할 사람과 실행 결과의 수는 같아야 합니다.");
        }
    }
}
